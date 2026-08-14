package socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WhileServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("--- 클라이언트의 연결을 기다립니다 ---");
            Socket socket = serverSocket.accept(); // 블로킹
            System.out.println("=== 클라이언트 연결 완료 ===");

            // 입력/ 출력 스트림 준비
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // <- 데코레이터 패턴
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 클라이언트가 먼저 메세지를 보내면 ---> 서버측에서 데이터를 읽고
            // ---> 답을 주기위해 (키보드에서 답 입력) --> 클라이언트에게 응답
            String line;
            while ( (line = reader.readLine()) != null) {
                // 프로토콜: exit 문자열이 들어오면 프로그램 종료
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                System.out.println("클라이언트 >> " + line);
            }
            // 서버측에서 키보드의 값을 받아서 보내기
            System.out.println("--- 콘솔 로그 --- 내용 입력 ---");
            // sc.nextline();
           String serverKeyboardMessage = keyboardReader.readLine(); // 블로킹
            // 키보드에서 입력 받은 값을 클라이언트와 연결되어 있는 출력 스트림을 통해서 보내기
            writer.println(serverKeyboardMessage);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
