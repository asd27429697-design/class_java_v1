package useful.ch17;

import java.util.Arrays;
import java.util.List;

// map <- 변환
public class StreamDemo5 {

    public static void main(String[] args) {

        List<Double> prices = Arrays.asList(100.0,200.0,300.0);

        // 원래 금액 10% 할인된 금액을 만들어야 할 때
        List<Double> discount = prices.stream()
                .map(p -> p * 0.9)
                .toList();

        discount.forEach(e -> System.out.println("할인 된 가격: " + e));


    }
}
