package client_socket.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile3 {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.01", 5000)) {
            System.out.println("클라이언트: 서버에 연결했습니다");

            socket.getOutputStream();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("안녕 반가워✌️✌️👍👌👍👌👍");
            writer.println("️안녕 잘가~~~~👍👌👍👌👍");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
