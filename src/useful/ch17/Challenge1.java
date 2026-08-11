package useful.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge1 {

    public static void main(String[] args) {
        // 도전과제 1 - Stream API 를 사용하지 않고 만들어 보기
        // 짝수만 골라서 어딘가 담아야 한다면 --> List 생성
        // 짝수만 받아서 그 수를 제곱 어딘가 담아야 한다면 List 생성
        // 결과를 담을 빈 리스트를 만든다. 동시에 (하나만 생성)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result2 = new ArrayList<>();
            // 2. 하나씩 꺼내서 처리한다
        for (Integer num : numbers) {
            // 3. 조건을 검사 한다. 만약 짝수라면 (filter)
            if (num % 2 == 0) {
                // 4. 값을 변경한다 (map)
                result2.add(num * num);
                // 5. 값을 담아준다 (toList 에 해당)
            }
        }
        System.out.println("for문 " + result2);

        //## 도전 문제 1. 짝수만 골라 제곱하기
        //숫자 리스트에서 짝수만 필터링한 뒤, 각 짝수를 제곱하여 리스트로 반환하시오.

       java.util.List<Integer> result = numbers.stream()
               .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();

        System.out.println(result.toString());

    }
}
