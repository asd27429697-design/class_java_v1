package useful.ch12;

import java.time.LocalDate;
import java.time.Period;

public class Step3 {

    public static void main(String[] args) {
        // Period - 나이와 D-day 구하기

        LocalDate birth = LocalDate.of(2001,10,31);
        LocalDate today = LocalDate.of(2026,8,7);
        // period 클래스입니다. 년,월,일 세 개의 int를 하나로 묶어서 담아두는 상자 입니다.
        Period age = Period.between(birth, today);  // <-- 만나이로 계산

        System.out.println("나이: " + age.getYears() + "살");
        System.out.println("정확히: " + age.getYears() + "년" + age.getMonths() + "개월"+ age.getDays() + "일");

        // period 객체를 그대로 출력하면 안됩니다
        System.out.println(age); // 사람이 읽는 형식이 아님
    }
}
