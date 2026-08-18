package client_socket.ch07;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 서버와 미리 약속한 데이터 순서 준수 ( 프로토콜 )
 * [1바이트] 파일 이름의 길이 (0 ~ 255)
 * [N바이트] 파일 이름
 * [나머지]  파일 내용
 */
public class FileClient2 {

    private static String HOST = "192.168.5.21";
    private static int PORT = 5000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("전송할 파일 경로 예) C:\\work_java\\test.txt");

        String filePath = "C:\\khs\\work_space\\java_class_1\\java_v1\\assets\\a.txt";

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("파일이 존재하지 않거나 폴더 경로입니다 : " + filePath);
            return;
        }
        String fileName = file.getName();
        byte[] nameBytes = fileName.getBytes();

        if (nameBytes.length > 255) {
            System.out.println("파일 이름이 너무 깁니다 (최다 255바이트)");
            return;
        }
        System.out.println("전송할 파일 : " + fileName + "( " + file.length() + " 바이트)");

        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();


            out.write(nameBytes.length);

            out.write(nameBytes);

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            out.flush();

            System.out.println("전송 완료");


            byte[] responseBuffer = new byte[1024];
            int responseLength = in.read(responseBuffer);
            if (responseLength > 0) {
                System.out.println(" 서버 응답 : " + new String(responseBuffer, 0, responseLength));
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
