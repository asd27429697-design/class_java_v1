package exercise.example;

import java.util.Scanner;

public class Example04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int number = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 || i % 4 == 0) {
                sum += i;

            }
        }
        System.out.println("3과 4의 배수의 합: " + sum);
        sc.close();
    }
}
