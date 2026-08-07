package exercise.example;


import java.util.Scanner;

public class Example09 {
    public static void main(String[] args) {
//        문제1: 마트에서 산 사과 3개의 무게가 각각 0.35kg, 0.42kg, 0.29kg입니다.
//        이 세 무게를 알맞은 실수형 변수 3개에 나누어 담으세요.
//        그 후, 세 사과 무게의 총합(실수)을 구하고, 그 총합을
//        정수형으로 강제 형 변환하여 소수점을 버린 정수 무게만 화면에 출력하세요.

        double kg1 = 0.35;
        double kg2 = 0.42;
        double kg3 = 0.29;

        double apple = (kg1 + kg2 + kg3);
        System.out.println("사과 무게 총합은: " + (int) apple + "kg");

        System.out.println("------------------------------------");

//       문제2: 자격증 시험을 보았습니다.
//       1과목 점수 int score1 = 80;, 2과목 점수 int score2 = 55;를 각각 선언하세요.
//       다음 합격 조건을 if - else 문으로
//       구현하여 "합격입니다" 또는 "불합격입니다"를 출력하세요.
//       합격 조건: 두 과목의 점수가 모두 60점 이상이어야 합격입니다.
//       (한 과목이라도 60점 미만이면 불합격입니다.)

        int score1 = 80;
        int score2 = 55;

        if (score1 >= 60 && score2 >= 60) {
            System.out.println("합격입니다");
        } else {
            System.out.println("불합격입니다");
        }

        System.out.println("---------------------------");

//        문제3: for 반복문을 사용하여 1부터 30까지 숫자를 돌리세요.
//        그중 5의 배수(5, 10, 15...)들만 골라서 화면에 출력하고,
//        마지막에는 5의 배수가 총 몇 개였는지 개수를 출력하는 프로그램을 작성하세요.
        int count = 0;

        for (int i = 1; i <= 30; i++) {
            if (i % 5 == 0) {
                System.out.println("5의 배수: " + i);
                count += 1;
            }
        }
        System.out.println("5의 배수의 개수: " + count);

        System.out.println("-----------------------------");

//        문제4: 진짜 비밀번호인 정수 final int PASSWORD = 1234;를 상수로 선언하세요.
//        Scanner와 while(true) 문을 사용하여 사용자에게 계속 비밀번호를 입력받습니다.
//        비밀번호가 맞으면 "로그인 성공!"을 출력하고 break로 탈출합니다.
//        틀리면 "비밀번호가 틀렸습니다."를 출력하고 틀린 횟수를 1씩 누적합니다.
//        만약 틀린 횟수가 5번이 되는 순간 "비밀번호 5회 오류로 계정이 잠깁니다."를
//        출력하고 break로 강제 종료하세요.

        final int PASSWORD = 1234;
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요: ");
        int count1 = 0;

        while (true) {
            int input = sc.nextInt();
            if (input == PASSWORD) {
                System.out.println("로그인 성공!");
                break;
            } else {
                count1++;
                System.out.println("비밀번호가 틀렸습니다");
                if (count1 >= 5) {
                    System.out.println("비밀번호가 5회 오류가 났습니다");
                    break;
                }
            }

        }
        System.out.println("---------------------------------");

//   문제5: while(true) 무한 루프 안에서 1씩 증가하는 정수 변수 int num = 0;과
//   총합을 담을 바구니 int sum = 0;을 활용해 아래 조건을 구현하세요.
//   숫자가 짝수라면 더하지 않고 패스(continue)하세요.
//   숫자가 홀수라면 총합 바구니에 더하세요(sum = sum + num;).홀수들을 계속 더하다가,
//   총합(sum)이 150을 초과(>)하는 순간 "탈출 당시 홀수: [숫자]"를 출력하고 break하세요.
//   while문이 완전히 다 끝난 바깥에서 "최종 홀수 총합: [결과값]"을 딱 한 번만 출력하세요.

        int num = 0;
        int sum = 0;

        while (true) {
            num++;
            if (num % 2 == 0) {
                continue;
            }
            sum = sum + num;

            if (sum > 150) {
                System.out.println("탈출 당시 홀수: " + num);
                break;
            }
        }
        System.out.println("최종 홀수 총합: " + sum);

    }
}
