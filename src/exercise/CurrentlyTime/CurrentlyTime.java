package exercise.CurrentlyTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CurrentlyTime {

    public static void main(String[] args) {
        // 1. 생일이 무슨 요일이었는지
        LocalDate birthday = LocalDate.of(2001,10,31);
        String week = birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        System.out.println("태어난 요일: " + week);
        // 2. 만 나이
        LocalDate today = LocalDate.of(2026,8,7);
        int age = Period.between(birthday,today).getYears();
        System.out.println("만 나이: " + age);

        // 3. 태어난 지 총 며칠
        long born = ChronoUnit.DAYS.between(birthday,today);
        System.out.println("태어난지: "+ born + "일");

        // 4. 크리스마스까지 D-day
        LocalDate christmas = LocalDate.of(2026,12,25);
        long dDay = ChronoUnit.DAYS.between(today,christmas);
        System.out.println("크리스마스까지: " + dDay + "일");


        // 5. 원하는 형식으로 출력
    }


}
