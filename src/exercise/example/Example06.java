package exercise.example;

import java.util.Scanner;

public class Example06 {
    public static void main(String[] args) {
//         사용자로부터 숫자 (정수) 하나를 입력받습니다 .1 부터 100 까지의 숫자 중에서
//         사용자가 입력한 숫자의 배수만 화면에 출력하세요.반복문이 끝난 후,
//        화면에 출력된 배수들의 총합(더한 값) 을 마지막에 출력하세요.단,
//        반복문 작동 중 숫자가 80 이상이 되면 즉시 반복을 종료( break)해야 합니다

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int number = sc.nextInt();

        int num1 = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % number == 0) {
                System.out.println(i);
                num1 += i;
            }
            if (i >= 80) {
                System.out.println("80 멈춤");
                break;
            }
        }
        System.out.println("총합: " + num1);
    }
}
