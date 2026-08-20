package http.ch04;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UserListClient {

    public static void main(String[] args) {
        // https://jsonplaceholder.typicode.com/users/1

        String urlString = "https://jsonplaceholder.typicode.com/users";
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

                TypeToken<List<User>> typeToken = new TypeToken<List<User>>() {};
                List<User> userList = gson.fromJson(builder.toString(), typeToken.getType());

                System.out.println("전체 개수: " + userList.size());
                for (int i = 0; i < 5; i++) {
                    System.out.println(userList.get(i));
                }

                User user = gson.fromJson(builder.toString(), User.class);
                System.out.println("결과");
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
