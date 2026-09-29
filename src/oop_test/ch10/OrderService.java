package oop_test.ch10;

import java.util.List;

public class OrderService {
    private OrderDao dao;
    private DiscountPolicy discountPolicy;


    public OrderService(OrderDao dao, DiscountPolicy discountPolicy) {
        this.dao = dao;
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuName, int price) {
        int discountAmount = discountPolicy.discount(price);
        int finalPrice = price - discountAmount;
        Order newOrder = new Order(menuName, finalPrice);
        dao.insert(newOrder);
    }

    public void printAllOrders() {
        List<Order> orders = dao.findAll();
        System.out.println("--- 전체 주문 내역 (할인 적용가) ---");
        for (Order order : orders) {
            System.out.println("메뉴: " + order.getMenuName() + " | 결제 금액: " + order.getPrice() + "원");
        }
    }
}