package socket.ch02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile2 {
    // 내 ip 주소: 192.168.5.19
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버 측 프로그램 시작 - 포트 번호: 5000에서 대기중...");
            Socket socket = serverSocket.accept();

            // 읽기 스트림(문자기반), 클라이언트 --> 서버
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 쓰기 스트림(문자기반), 서버 --> 클라이언트
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // 클라이언트가 보낸 데이터 한 줄 읽기
            String message = reader.readLine();
            System.out.println("클라이언트 메세지: " + message);

            // 서버가 클라이언트로 응답 메세지 보내기
            writer.println("안녕 나는 서버야 !!!");

            // 공통 과제
            // 서버측에서 클라이언트가온 메세지를 파일에 저장하는 기능을 만들어 주세요
            try (FileWriter fw = new FileWriter("assets/a.txt", true)) {
                fw.write(message);
                fw.flush();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
