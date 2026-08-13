package socket.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
    // 내 ip 주소: 192.168.5.19
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버 측 프로그램 시작 - 포트 번호: 5000에서 대기중...");
            Socket socket = serverSocket.accept();

            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String massage = br.readLine();
            System.out.println("클라이언트가 보낸 메세지: " + massage);
            String massage2 = br.readLine();
            System.out.println("클라이언트가 보낸 메세지2: " + massage2);

            System.out.println("클라이언트가 연결되었습니다");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
