package exercise.example;

import java.util.Scanner;

public class Example08 {
    public static void main(String[] args) {

//    문제1: 국어 점수 85, 영어 점수 90, 수학 점수 78을 각각 알맞은
//    정수형 변수에 저장하세요. 그 후, 세 점수의 총점(정수)과 평균(실수, 소수점까지 표시)을
//    계산하여 화면에 출력하는 프로그램을 작성하세요.
        int korean = 85;
        int english = 90;
        int math = 78;

        int score = (korean + english + math);
        System.out.println("총점: " + score);
        double finalScore = score / 3.0;
        System.out.println("평균: " + finalScore);

        System.out.println("----------------------------------");

//       문제2: 나이를 뜻하는 정수 변수 int age를 선언하고 원하는 나이를 대입하세요.
//        나이에 따라 다음과 같이 입장료를 출력하는 프로그램을 if - else if - else 문으로 작성하세요.
//        8세 미만: "미취학 아동은 무료 입장입니다."8세 이상 ~ 19세 이하: "청소년 요금은 5,000원입니다."20세 이상: "성인 요금은 10,000원입니다."
        int age = 20;

        if (age < 8) {
            System.out.println("8세 미만: 미취학 아동은 무료 입장입니다.");
        } else if (age <= 19) {
            System.out.println("8세 이상 ~ 19세 이하: 청소년 요금은 5000원입니다");
        } else {
            System.out.println("성인 요금은 10000원입니다");
        }

        System.out.println("------------------------------------");

//        문제3: for 반복문을 사용하여 1부터 50까지의 숫자 중
//        '짝수'들만 골라 모두 더한 값을 출력하는 프로그램을 작성하세요.
        int total = 0;

        for (int i = 1; i <= 50; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                total += i;
            }
        }
        System.out.println("총합: " + total);

//        문제4: Scanner를 사용하여 사용자에게 계속해서 숫자를 입력받으세요.
//        사용자가 숫자를 입력할 때마다 그 숫자를 계속 누적해서 더해나갑니다.
//        그러다가 사용자가 숫자 0을 입력하는 순간,
//        "프로그램을 종료합니다"라는 메시지와 함께 그동안 더한
//        '최종 총합'을 출력하고 반복문을 탈출(break)하는 프로그램을 작성하세요.
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");

        int sum = 0;

        while (true) {
            int num1 = sc.nextInt();
            if (num1 == 0) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            sum += num1;
        }
        System.out.println("그 동안 입력한 숫자의 총합: " + sum);
        sc.close();

        System.out.println("----------------------------------------");
//        문제5: while(true) 무한 루프와 1씩 증가하는 카운트 변수를 만드세요.
//        숫자를 1부터 차례대로 계속 더해나가되, 아래의 조건을 break와 continue로 구현하세요.
//        만약 더하려는 숫자가 3의 배수라면 더하지 않고 건너뛰세요(continue).
//        숫자를 계속 누적하다가 총합이 100을 넘어가는 순간, 반복문을 즉시 중단하고 탈출(break)하세요.
//        마지막에 "최종 총합: [결과값]"을 화면에 출력하세요.

        int num2 = 0;
        int sum1 = 0;

        while (true) {
            num2++;
            if (num2 % 3 == 0) {
                continue;
            }
            sum1 = sum1 + num2;
            if (sum > 100) {
                System.out.println("탈출! 숫자는: " + num2);
                break;

            }
        }
        System.out.println("최종총합: " + sum1);

    }
}
