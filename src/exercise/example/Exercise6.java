package exercise.example;

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int maxNumber = scanner.nextInt();

        int sum = 0;

        for (int i = 1; i < maxNumber; i++) {
           if (i % 2 == 0) {
            sum+= i;
           }
        }
        System.out.println("짝수의 합: " + sum);
        scanner.close();

        for (int i = 1; i <= maxNumber; i++) {
            if (i % 3 == 0) {
                sum+= i;
            }
        }
        System.out.println("3의 배수의 합은: " + sum);
        scanner.close();

    } // end of main

} // end of class
