package http.ch03;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TodoClient {

    public static void main(String[] args) {
        //HTTP 통신을 활용한 단건 조회
        String urlString = "https://jsonplaceholder.typicode.com/todos/1";
        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            // HTTP 프로토콜 설정 (GET 요청)
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode(); // 통신 진행
            System.out.println("응답 코드 확인 " + responseCode);

            if (responseCode != 200) {
                System.out.println("요청 실패!");
                return;
            }

            // 응답 본문(HTTP 메세지 Body 영역에서 내용 추출)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                // GSON 라이브러리 활용
                Gson gson = new Gson();
                // fromJson(json 문자열, 변환할 클래스)
                Todo todo = gson.fromJson(sb.toString(), Todo.class);
                System.out.println("파싱 결과");
                System.out.println(todo.getId());
                System.out.println(todo.getTitle());
                System.out.println(todo.isCompleted());
                System.out.println(todo.getUserId());

                System.out.println(todo.toString());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }


    } // end of main
}
