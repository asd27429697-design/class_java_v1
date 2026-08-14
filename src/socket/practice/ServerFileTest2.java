package socket.practice;
// 1. 서버 소켓 생성 및 포트 설정

// 2. 클라이언트 연결 대기

// 3. 입력 / 출력 스트림 준비
//    클라이언트 → 서버 : reader
//    서버 → 클라이언트 : writer
//    키보드 → 서버 : keyboardReader

// 4. 읽기 스레드 생성
//    클라이언트 메시지 수신

// 5. 쓰기 스레드 생성
//    키보드 입력 → 클라이언트 전송

// 6. 두 스레드 실행

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 7. 두 스레드가 종료될 때까지 대기
public class ServerFileTest2 {
    // 내 IP 주소 : 192.168.5.101
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("==== 서버 실행 ====");
           Socket socket = serverSocket.accept();
            System.out.println("클라이언트 연결 됨");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            Thread readTread = new Thread( () -> {
               String clientMessage;
               try {
                   while ( (clientMessage = reader.readLine()) != null ) {
                       System.out.println("클라이언트 측 메세지: " + clientMessage);
                       if ("exit".equalsIgnoreCase(clientMessage)) {
                           System.out.println("클라이언트가 강제로 종료를 했습니다");
                           break;
                       }
                   }

               } catch (Exception e) {
                   System.out.println("클라이언트가 강제로 연결이 끊겼습니다");
               }
            });

            Thread writeThread = new Thread( (new Runnable() {
                @Override
                public void run() {
                    String serverMessage;
                    try {
                        while ( (serverMessage = keyboardReader.readLine()) != null ) {
                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료되었습니다");
                                break;
                            }
                            writer.println("[서버 응답 메세지]: " + serverMessage);
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }) );

            readTread.start();
            writeThread.start();

            readTread.join();
            writeThread.join();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
