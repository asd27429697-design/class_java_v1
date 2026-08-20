package http.ch04;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserClient {

    public static void main(String[] args) {
        // https://jsonplaceholder.typicode.com/users/1

        String urlString = "https://jsonplaceholder.typicode.com/users/1";
        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            if (responseCode != 200) {
                System.out.println("응답 실패!");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder builder = new StringBuilder();
                String line;
                while ( (line = reader.readLine()) != null) {
                    builder.append(line);
                }

                Gson gson = new Gson();
                User user = gson.fromJson(builder.toString(), User.class);
                System.out.println("파싱 결과");
                System.out.println(user.toString());

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
