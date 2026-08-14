package client_socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhileClient {

    public static void main(String[] args) {

        // 도전 과제.
        // 주석으로 무엇을 해야될지 작성해보자
        // 1. 소켓 준비 (서버 IP 주소, 포트 번호)
        // 2. 소켓과 연결된 입력/출력 스트림이 필요
        // 3. 클라이언트 측 키보드 스트림 필요

        try (Socket socket = new Socket("localhost", 5000)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while ((true)) {
                System.out.println("[client]콘솔 로그 클라이언트 입력 >>>>");
                String input = keyboardReader.readLine(); // 블로킹 sc.nextline();
                writer.println(input); // 소켓과 연결된 출력 스트림을 사용해서 서버측에 데이트를 보냄
                if ("exit".equalsIgnoreCase(input)) {
                    break; // 즉 키보드 입력 스트림 종료
                }
                // 서버측에서 보낸 메세지를 받아서 클라이언트 콘솔창에 출력
                String response = reader.readLine();
                if ("exit".equalsIgnoreCase(response)) {
                    break;
                }
                System.out.println("서버측 응답: " + response);
            }



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    } // end of main
}
