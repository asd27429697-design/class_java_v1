package client_socket.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임을 입력하세요: ");
        String name = sc.nextLine();

        try (Socket socket = new Socket("192.168.5.101", 5002)) {
            System.out.println(name + "님, 채팅방 입장 했음(종료: exit) ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드 (서버측에서 들어온 데이터를 계속 받을 수 있도록 처리)
            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = reader.readLine()) != null) {
                        // 프로토콜 1 - exit
                        if ("exit".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버가 종료를 원합니다");
                            break;
                        }
                        System.out.println(serverMessage);
                    }
                } catch (Exception e) {
                    System.err.println("서버가 강제 종료 했습니다");
                }
            });

            // 쓰기 스레드 ( 클라이언트 측 키보드 값을 입력 받아서 서버측으로 전송)
            Thread writeThread = new Thread(() -> {
                String clientMessage;
                try {
                    while ((clientMessage = keyboardReader.readLine()) != null) {
                        writer.println(name + ": " + clientMessage);
                        if ("exit".equalsIgnoreCase(clientMessage)) {
                            System.out.println("클라이언트 종료 됨");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("메세지 전송 중 오류 발생");
                }
            });

            readThread.start();
            writeThread.start();
            // 메인 스레드 종료시 socket.close() 가 호출 됨 그래서 대기 상태로 만들어 줘야 함
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
