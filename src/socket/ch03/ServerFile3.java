package socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile3 {
    // 내 ip 주소: 192.168.5.19
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("포트 5000에서 대기중...");
            Socket socket = serverSocket.accept();

            InputStream in = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            String message = bufferedReader.readLine();
            System.out.println("보낸 메세지 " + message);
            String message2 = bufferedReader.readLine();
            System.out.println("보낸 메세지 " + message2);

            System.out.println("메세지 전송을 완료했습니다");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
