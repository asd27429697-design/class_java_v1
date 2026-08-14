package socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTreadServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("============= 서버 실행 ================");
            Socket socket = serverSocket.accept();
            System.out.println("============= 클라이언트 연결 됨 ================");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드: 클라이언트에게 온 메세지만 수신 함
            Thread readThread = new Thread(() -> {
                String clintMessage;
                try {
                    while ((clintMessage = reader.readLine()) != null) {
                        System.out.println("[클라이언트 측 메시지]: " + clintMessage);
                        if ("exit".equalsIgnoreCase(clintMessage)) {
                            System.out.println("클라이언트가 종료를 원합니다");
                            break;
                        }
                    }
                } catch (IOException e) {
                    // throw new RuntimeException(e);
                    System.err.println("클라이언트가 강제로 연결을 끊었습니다");
                }
            });

            // 쓰기 스레드: 키보드에서 값을 입력받아서 클라이언트에게 전달
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String serverMessage;
                    try {
                        while ((serverMessage = keyboardReader.readLine()) != null) {
                            writer.println(serverMessage);
                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료했습니다");
                                break;
                            }
                            writer.println("[서버] 응답 메세지: " + serverMessage); // '\n' 포함
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();
            // 메인 스레드에게 내가 종료 될 때까지 기다려


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
