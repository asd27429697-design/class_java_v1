package useful.ch12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Step6 {

    public static void main(String[] args) {
        // 1.
        LocalDate birthday = LocalDate.of(2001, 10, 31);
        System.out.println("생일 요일: " + birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
        // 2.
        LocalDate birth = LocalDate.of(2001, 10, 31);
        LocalDate today = LocalDate.of(2026, 8, 7);
        // 3.
        Period age = Period.between(birth, today);
        System.out.println("나이: " + age.getYears() + "살");
        System.out.println("살아온 날: " + ChronoUnit.DAYS.between(birth, today) + "일");
        // 4.
        LocalDate today3 = LocalDate.of(2026, 8, 7);
        LocalDate crisMas = LocalDate.of(2026, 12, 25);
        System.out.println("크리스마스까지: " + ChronoUnit.DAYS.between(today3, crisMas) + "일");
        // 5.
        LocalDateTime now = LocalDateTime.of(2025, 5, 13, 2, 30);
        DateTimeFormatter korean1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분", Locale.KOREAN);
        System.out.println(now.format(korean1));


        // 도전과제 2

        long sum = 0;

        LocalDateTime start = LocalDateTime.now();

        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }

        LocalDateTime end = LocalDateTime.now();

        Duration time = Duration.between(start, end);

        System.out.println("합계: " + sum);
        System.out.println("걸린 시간: " + time.toMillis() + "ms");

    }
}
