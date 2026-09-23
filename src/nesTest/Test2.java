package nesTest;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuPrice = 0;
        int count = 0;

        System.out.println("=== 스마트 카페 키오스크 ===");
        System.out.println("1. 아메리카노(2000원)  2. 카페라떼(3000원)");

        // 1. 메뉴 선택 (제약사항 처리 포함)
        while (true) {
            System.out.print("메뉴 번호를 선택하세요 (1 또는 2): ");
            int menu = sc.nextInt();

            if (menu == 1) {
                menuPrice = 2000;
                break;
            } else if (menu == 2) {
                menuPrice = 3000;
                break;
            } else {
                System.out.println("[시스템 경고] 없는 메뉴입니다. 1번이나 2번을 눌러주세요.\n");
            }
        }

        // 2. 수량 입력 (제약사항 처리 포함)
        while (true) {
            System.out.print("주문할 수량을 입력하세요 (최소 1잔 이상): ");
            count = sc.nextInt();

            if (count > 0) {
                break;
            } else {
                System.out.println("[시스템 경고] 수량은 1잔 이상이어야 합니다.\n");
            }
        }

        // 3. 결제 금액 계산 및 결과 출력
        int totalPrice = count * menuPrice;
        System.out.println("\n--- 주문 명세서 ---");
        System.out.println("총 결제 금액: " + totalPrice + "원");

        // 4. 서비스 기능 (조건부 로직)
        if (count >= 3) {
            System.out.println("★ 3잔 이상 구매 이벤트! 무료 쿠폰이 발급되었습니다.");
        }
        System.out.println("이용해 주셔서 감사합니다.");
    }
}

