package oop_test.ch10;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new MemoryOrderDao();
        // OrderDao orderDao = new LogOrderDao();

        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        // DiscountPolicy discountPolicy = new FixDiscountPolicy();

        OrderService service = new OrderService(orderDao, discountPolicy);


        service.takeOrder("아메리카노", 4500);
        service.takeOrder("카페라떼", 5000);
        service.takeOrder("바닐라라떼", 5500);

        System.out.println();

        service.printAllOrders();
    }
}