package http.practice;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 1. URL 준비
// 2. 연결 변수 준비
// 3. 서버에 연결 + GET 요청
// 4. 요청 보내고 응답 코드 확인
// 5. Response Body 읽기
// 6. JSON → Java 객체
// 7. 결과 출력 + 연결 정리

public class Test3 {

    public static void main(String[] args) {
        // 1. URL 준비
        String urlString = "https://jsonplaceholder.typicode.com/users/5";
        // 2. 연결 변수 준비
        HttpURLConnection conn = null;

        // 3. 서버에 연결 + GET 요청
        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 4. 요청 보내고 응답 코드 확인
            int response = conn.getResponseCode();
            System.out.println("응답 코드: " + response);
            if (response != 200) {
                System.out.println("응답 실패!!");
                return;

                // 5. Response Body 읽기
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder builder = new StringBuilder();

              String line;

              while ( (line = reader.readLine()) != null) {
                  builder.append(line);
              }

              Gson gson = new Gson();
              User user = gson.fromJson(builder.toString(), User.class);

                System.out.println("응답 코드");
                System.out.println(user);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
