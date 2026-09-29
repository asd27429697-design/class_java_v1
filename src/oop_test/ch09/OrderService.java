package oop_test.ch09;

public class OrderService {
    // 인터페이스로 참여
    private DiscountPolicy discountPolicy;

    // DI - 생성자 의존 주입
    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuMame, int price) {
        Order newOrder = new Order(menuMame, price);
        int discountAmount = discountPolicy.discount(newOrder.getPrice());
        int finalPrice = newOrder.getPrice() - discountAmount;
        System.out.println(newOrder.getMenuName() + " || 정가 : " +
                newOrder.getPrice() + " 원 | 할인 : " + discountAmount + " 원 | 결제 금액 : " + finalPrice + "원");
    }
}
