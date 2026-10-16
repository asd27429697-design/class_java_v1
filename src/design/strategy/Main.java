package design.strategy;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HexFormat;

public class Main {

    public static void main(String[] args) {
        String message = "hello Java 안녕";

        // 문자열 UTF-8 바이트 배열로 변환
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        // 1. URL 인코딩
        String url = URLEncoder.encode(message, StandardCharsets.UTF_8);
        // 2. Base64 인코딩
        String base64 = Base64.getEncoder().encodeToString(bytes);
        // 3. Hex(16진수) 인코딩
        String hex = HexFormat.of().formatHex(bytes);

        System.out.println("원본 : " + message);
        System.out.println("URL : " + url);
        System.out.println("Base64 : " + base64);
        System.out.println("Hex : " + hex);

        System.out.println(bytes.toString());

        String selected = "1";
        String target;
        if (selected.equals("1")) {
            target = URLEncoder.encode(message, StandardCharsets.UTF_8);
        } else if (selected.equals("2")) {
            target = Base64.getEncoder().encodeToString(bytes);
        } else if (selected.equals("3")) {
            target = HexFormat.of().formatHex(bytes);
        }

        // 테스트
        Base64Strategy base64Strategy = new Base64Strategy();
        System.out.println(base64Strategy.encode("반가    워 안녕"));

    } // end of main
}
