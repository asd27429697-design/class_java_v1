package client_socket.practice;

// 1. 서버에 연결
//    IP 주소 + 포트 번호

// 2. 입력 / 출력 스트림 준비
//    서버 → 클라이언트 : reader
//    클라이언트 → 서버 : writer
//    키보드 → 클라이언트 : keyboardReader

// 3. 읽기 스레드 생성
//    서버 메시지 수신

// 4. 쓰기 스레드 생성
//    키보드 입력 → 서버 전송

// 5. 두 스레드 실행

// 6. 두 스레드가 종료될 때까지 대기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFileTest2 {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5000)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            Thread readThread = new Thread( () -> {
                try {
                    String serverMessage;
                    while ( (serverMessage = reader.readLine()) != null) {
                        if ("exit".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버를 종료합니다");
                            break;
                        }
                        System.out.println(serverMessage);
                    }
                } catch (Exception e) {
                    System.out.println("서버가 강제 종료되었습니다");
                }
            });

            Thread writeThread = new Thread( () -> {
               try {
                   String clientMessage;
                   while ( (clientMessage = keyboardReader.readLine()) != null) {
                       writer.println(clientMessage);
                       if ("exit".equalsIgnoreCase(clientMessage)) {
                           System.out.println("서버를 종료합니다");
                           break;
                       }
                   }

               } catch (Exception e) {
                   System.out.println("메세지 전송 중 오류 발생");
               }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
