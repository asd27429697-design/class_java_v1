package ch08;

import java.util.Scanner;

public class BreakTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int number = sc.nextInt();

        // 문제 1. 1부터 100까지 화면에 출력
        //     2. 3의 배수만 화면에 출력하시오
        //     3. 50이상이면 반복문을 종료 시키세요
        //     4. for 구문을 코드 작성
        for (int i = 1; i <= 100; i++) {
          if (i % 3 == 0) {
              System.out.println(i);
          }
            if (i >= number) {
                break;
            }
            sc.close();
        }





    } // end of main
} // end of class
