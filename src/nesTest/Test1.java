package nesTest;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int americanoPrice = 2500;
        int quantity;

        while (true) {
            System.out.println("아메리카노 수량을 입력하세요");
            quantity = sc.nextInt();

            if (quantity > 0) {
                break;
            } else {
                System.out.println("1잔 이상 주문해야 합니다");
            }
        }
        int total = quantity * americanoPrice;
        System.out.println("총 결제 금액: " + total + "원");

        if (quantity >= 3) {
            System.out.println("3잔 이상 구매 서비스 스탬프 발급: ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
