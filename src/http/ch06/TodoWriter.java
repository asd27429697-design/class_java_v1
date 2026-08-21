package http.ch06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TodoWriter {

    public static void main(String[] args) {

        // 자바 객체를 --> json 문자열로 변환 방법
        Todo todo = new Todo();
        todo.setUserId(100);
        todo.setId(400);
        todo.setTitle("오늘은 총 복습을 해야 합니다");
        todo.setCompleted(false);

        Gson gson = new Gson();
        System.out.println(gson.toJson(todo));
        System.out.println();
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(todo));

    } // end of main
}
