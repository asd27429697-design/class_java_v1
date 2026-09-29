package oop_test.ch09;

public class Main {
    public static void main(String[] args) {
        // DiscountPolicy discountPolicy = new FixDiscountPolicy();
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        OrderService orderService = new OrderService(discountPolicy);

        orderService.takeOrder("아메리카노", 4500);
        orderService.takeOrder("카페라떼", 5000);
        orderService.takeOrder("바닐라라떼", 5500);


    }
}
