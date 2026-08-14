package client_socket.practice;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFileTest {
    // 소켓 IP 주소 + 포트번호 작성

    // 쓰기 스트림( 클라이언트 ---> 서버)

    // 읽기 스트림 (서버 ---> 클라이언트)

    // 서버측으로 보낼 메세지

    // 서버 응답 수신
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("클라이언트에 연결했습니다");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println("안녕 반가워 나는 클라이언트라고 해!!!");

            String message = reader.readLine();
            System.out.println("서버 응답: " + message);



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
