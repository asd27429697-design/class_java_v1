package exercise.example;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int americano = 2500;
        int count = 0;

        while (true) {
            System.out.println("수량을 입력하세요");
            count = sc.nextInt();

            if (count <= 0) {
                System.out.println("1잔 이상 주문해야 합니다");
            } else {
                System.out.println("총 결제 금액: " + (americano * count) + "원");
                if (count >= 3) {
                    System.out.println("3잔 이상 구매 서비스 스탬프 발급:");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) System.out.print("* ");
                        System.out.println();
                    }
                }
                break;
            }
        }
        sc.close();
    }
}