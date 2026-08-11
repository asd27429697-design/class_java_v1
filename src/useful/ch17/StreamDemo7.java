package useful.ch17;

import java.util.Arrays;
import java.util.List;

// reduce - 최종 연산
public class StreamDemo7 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int sum = numbers.stream()
                // 매개변수 : 초기값, 매개변수 : 두 값을 합치는 방법
                .reduce(0, (a, b) -> a + b); // 최종 연산

        System.out.println(sum);

    }
}
