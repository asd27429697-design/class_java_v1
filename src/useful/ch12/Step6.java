package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Step6 {

    public static void main(String[] args) {
        // 도전 과제 풀어 보기
        // 테스트 데이터 (결과를 눈으로 확인하기 위해 고정값 사용)
        LocalDate birth = LocalDate.of(2001, 10, 31);
        LocalDate today = LocalDate.of(2025, 5, 13);
        LocalDateTime now = LocalDateTime.of(2025, 5, 13, 14, 30);
        LocalDate christmas = LocalDate.of(2025, 12, 25);

        // 1. 생일이 무슨 요일이었는지
        // getDayOfWeek()는 DayOfWeek 상수를 준다 (그냥 출력하면 FRIDAY)
        // getDisplayName으로 한국어 표기를 꺼낸다
        String dayName = birth.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.KOREAN);
        System.out.println("생일 요일: " + dayName);

        // 2. 만 나이
        // Period는 년/월/일을 따로 담는다. 년 자리만 꺼내면 만 나이가 된다
        int age = Period.between(birth, today).getYears();
        System.out.println("만 나이: " + age + "세");

        // 3. 태어난 지 총 며칠
        // 년/월/일로 쪼개지 않고 "날짜"라는 하나의 단위로 환산 -> ChronoUnit
        long livedDays = ChronoUnit.DAYS.between(birth, today);
        System.out.println("살아온 날: " + livedDays + "일");

        // 4. 크리스마스까지 D-day
        // 순서 주의: (기준일, 목표일) 순으로 넣어야 양수가 나온다
        long dday = ChronoUnit.DAYS.between(today, christmas);
        System.out.println("크리스마스까지: " + dday + "일");


        // 5. 원하는 형식으로 출력
        // a  : 오전/오후  (Locale.KOREAN이 있어야 한글로 나온다)
        // hh : 12시간제, 두 자리 (HH는 24시간제라 14로 나옴)
        // mm : 분  (MM은 월이므로 절대 혼동 금지)
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분", Locale.KOREAN);
        System.out.println("현재: " + now.format(fmt));

    }
}
