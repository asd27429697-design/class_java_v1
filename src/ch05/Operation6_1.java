package ch05;

/**
 *
 * .
 */
public class Operation6_1 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        // 쇼핑몰 회원 정보
        int userAge = 20; // 사용자 나이
        int cartTotal = 5000; // 장바구니 총 금액
        boolean isMember = true; // 회원 여부
        int couponCount = 2; // 보유 쿠폰 개수

        // 1. 무료 배송 조건: 장바구니 총액이 3만 원 이상이고 회원이어야 함
        //
        boolean free =  (cartTotal >= 30000) && (isMember == true);
        System.out.println("무료 배송 조건 확인: " + free);

        // 2. 할인 조건: 나이가 19세 이상이거나 쿠폰이 1개 이상 있어야 함
        boolean conDiscount = (userAge >= 19) || (couponCount >= 1);
        System.out.println("할인 조건 확인: " + conDiscount);

        // 3. 구매 제한 조건: 나이가 19세 미만이고 회원이 아닌 경우
        boolean buy = (userAge < 19) && (!isMember);
        System.out.println("구매 제한 조건 확인: " + buy);

        // 4. 이벤트 참여 조건: 장바구니 총액이 5만 원 미만이거나 쿠폰이 3개 미만
        boolean price = (cartTotal < 50000) || (couponCount < 3);
        System.out.println("이벤트 참여 조건 확인: " + price);


        // 연습 문제
        int price1 = 10000;
       int age = 20;

       boolean event = (age < 6) || (price1 < 1000);
        System.out.println("특별 이벤트 대사 확인: " + event);

    } // end of main

} // end of class
