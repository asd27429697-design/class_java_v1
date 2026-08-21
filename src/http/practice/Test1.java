package http.practice;

import com.google.gson.Gson;
import http.ch07.User;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test1 {

    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/comments/2";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString))
                    .GET().build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            System.out.println("응답 코드: " + response.statusCode());

            System.out.println("응답 바디: " + response.body());

            response.statusCode();

            response.body();

            Gson gson = new Gson();
            User user = gson.fromJson(response.body(),User.class);

            System.out.println("User 객체:");
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
