package useful.ch17;

import java.util.Arrays;
import java.util.List;

// 메서드 참조는 --> ;; <-- 세미콜론 2개를 의미
public class StreamDemo8 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("a1, bb2, cc3, dddd4");
        words.stream().map(s -> s.length()).forEach(e -> System.out.println("길이: " + e));

        // 람다식이 그 매개변수를 그대로 호출하는 형태 일때 더 짧게 줄여서 쓸 수 있다.
        words.stream().map(String::length).forEach(e -> System.out.println("길이2: " + e));


    }
}
