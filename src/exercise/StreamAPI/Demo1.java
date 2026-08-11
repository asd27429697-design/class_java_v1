package exercise.StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        // 다음 숫자 리스트에서 3의 배수만 골라서 2배한 결과

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = nums.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * 2)
                .toList();

        System.out.println(result);

        // 다음 리스트에서 20보다 큰 숫자가 몇 개인지

        List<Integer> numbers = Arrays.asList(10, 25, 30, 15, 40, 5, 50);
        long result1 = numbers.stream()
                .filter(n -> n > 20)
                .count();

        System.out.println(result1);

        // 숫자를 내림차순으로 정렬
        List<Integer> numbers1 = Arrays.asList(3, 8, 1, 6, 4, 9, 2);

        List<Integer> result2 = numbers1.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result2);

        // 50 이상인 숫자가 몇 개인지 구하기

        List<Integer> numbers3 = Arrays.asList(10, 50, 70, 20, 90, 30, 60);

        long result3 = numbers3.stream()
                .filter(n -> n >= 50)
                .count();

        System.out.println(result3);


    }
}
