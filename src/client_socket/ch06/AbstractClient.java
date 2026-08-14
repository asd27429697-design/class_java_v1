package client_socket.ch06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractClient {

    private String name;
    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketReaderStream;
    private BufferedReader keyboardReaderStream;

    public AbstractClient(String name) {
        this.name = name;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public final void run() {
        try {
            connectToServer();
            setupStreams();
            startCommunication();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 상속 받은 자식 클래스는 무조건 이 메서드를 재정의 해야 된다. (강제성 부여)
    protected abstract void connectToServer();

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketReaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReaderStream = new BufferedReader(new InputStreamReader(System.in));
    }

    private void startCommunication() throws InterruptedException {

        // 1. 서버에서 보낸 데이터를 받기
        Thread readThread = new Thread( () -> {
            String mag;
            try {
                while ( (mag = socketReaderStream.readLine()) != null ) {
                    System.out.println(mag);
                    // 프로토콜 생략 ...
                }
            } catch (Exception e) {
                System.err.println("서버와의 연결이 끊겼습니다");
            }

        } );

        // 키보드에서 값을 받아서 서버로 메세지 전송
        Thread writeTread = new Thread(() -> {
            String input;
            try {
                while ( (input = keyboardReaderStream.readLine()) != null ) {
                    socketWriterStream.println("[" + name + "] " + input);
                }
            } catch (Exception e) {
                System.err.println("메세지 전송 중 오류 발생");
            }

        });

        readThread.start();
        writeTread.start();
        readThread.join();
        writeTread.join();
    }

}
