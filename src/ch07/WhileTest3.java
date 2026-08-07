package ch07;

import java.util.Scanner;

public class WhileTest3 {

    public static void main(String[] args) {
        // 1 - 10 --> 55
        // 2. 끝 값을 스캐너를 통해서 받아서 연사 코드를 작성해보자.
        Scanner sc = new Scanner(System.in);
        System.out.print("마지막 값을 입력하시오 : ");

        int start = 1;
        int end = sc.nextInt();
        int sum = 0;

        while (start <= end) {
            sum = sum + start;
            start++;
        }

        System.out.println("sum의 총합: " + sum);

    } // end of main
} // end of class
