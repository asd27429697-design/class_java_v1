package useful.ch12;

import java.time.LocalDate;

public class Step2 {

    public static void main(String[] args) {

        LocalDate today = LocalDate.of(2026,8,7);

        System.out.println("다음 달: " + today.plusMonths(1));
        System.out.println("1년 전: " + today.minusYears(1));

    }
}
