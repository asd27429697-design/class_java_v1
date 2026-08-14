package socket.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
// 서버 소켓 포트번호 작성

// 읽기 스트림(문자기반) , 클라이언트 ---> 서버

// 쓰기 스트림(문자기반), 서버 ----> 클라이언트

// 클라이언트가 보낸 데이터 한 줄 읽기

// 서버가 클라이언트로 응답 메세지 보내기
public class ServerFileTest {
    // 내 IP 주소 : 192.168.5.101
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("현재 포트번호 5000에서 연결중 ...");
           Socket socket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message = reader.readLine();
            System.out.println("보낼 메세지: " + message);

            writer.println("안녕 반가워 나는 서버야 !!! 너는 누구야?");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
