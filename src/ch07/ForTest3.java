package ch07;

public class ForTest3 {

    public static void main(String[] args) {

        // 1 부터 100까지 수 중 총 합을 구하시오
        // 홀수만 덧셈해서 구하는 총합을 담아주세요
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                // sum = i + 1;
                sum += i;
            }
        }
        System.out.println("sum: " + sum);

        // 반복문의 증감식을 2씩 증가
        for (int i = 0; i < 10; i += 2) {
            System.out.println("2씩 증가 + " + i);
        }

        // 문제 - 화면에 10 9 8 7 6 5 4 3 2 1 를 출력하는 코드를 작성하시오
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("----------------------------------");

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("---------------------");

        for (int i = 7; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    } // end of main
} // end of class
