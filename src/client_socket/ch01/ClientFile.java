package client_socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {
    // 옆자리 ip 주소: 192.168.5.21
    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.01", 5000)) {
            System.out.println("클라이언트: 서버에 연결했습니다");

            // 서버측으로 메세지를 보내기 위한 출력 스트림 사용
            // socket + PrintWriter : autoFlush 처리 됨
            socket.getOutputStream();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("안녕 서버야 나는 클라이언트야. 내 데이터가 들어가니?");
            writer.println("안녕하세요 반갑습니다");

            // PrintWriter <-- autoFlush

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
