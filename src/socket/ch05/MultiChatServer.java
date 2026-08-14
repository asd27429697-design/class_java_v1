package socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultiChatServer {

    private static final int PORT = 5002;
    // Vector 는 멀티스레드 환경에서 안전한 동작을 한다. (이유는 모든 메서드에 동기화 처리 되어있기 때문에)
    private static Vector<PrintWriter> clintWriterList = new Vector<>();

    // 내부 클레스 선언 및 스레드 상속
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        // run() 메서드가 Thread() 시 일하는 약속되어 있는 메서드이다.
        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 추후 브로드 케스트 (접속자들에게 방송하기 위해서 생성된 출력 스틀미을 자료구조에 저장)
                clintWriterList.add(out);

                String message;
                while ( (message = in.readLine()) != null ) {
                    System.out.println("수신: " + message);
                    // A, B, C
                    // 받은 메세지를 현재 연결된 모든 클라이언트에게 전송(브로드 캐스트)
                    broadcast1(message);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 클라이언트가 강제 종료 및 우리만의 프로토콜 exit 값이 넘어 오면
                // 서버측에서 관리하고 있는 자료구조에서 출력 스트림을 제거 해야 한다.
                clintWriterList.remove(out); // 출력 스트림 제거
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ;
                }
            }
        }

        private void broadcast1(String msg) {
            for (PrintWriter w : clintWriterList) {
                // 자료구조에 저장된 출력스트림을 전체 꺼내서 하나씩 메세지 전송
                w.println(msg);
            }
        }
    } // end of inner class


    public static void main(String[] args) {
        System.out.println("---- 서버 시작 ----");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                // 클라이언트가 연결되면 새로운 객체를 생성하고 연결된 소켓 객체 주소값을
                // 해당 클래스 필드에 할당한다.
                new ClientHandler(socket).start();
                System.out.println("클라이언트 접속: 현재 접속자 " + clintWriterList.size() + "명");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    } // end of main
}
