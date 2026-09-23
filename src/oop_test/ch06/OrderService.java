package oop_test.ch06;

import java.util.List;

public class OrderService {

    // 1. 직접 생성하지 않고 선언만 함
    private OrderDao dao;

    // 2. 외부에서 생성된 객체를 파라미터로 주입 받게 설계 (DI)
    public OrderService(OrderDao dao)  {
        this.dao = dao;
    }

    public void takeOrder(String menuName, int price) {
        Order order = new Order(menuName, price);
        dao.insert(order);
    }

    public void PrintAllOrders() {
        List<Order> orders = dao.findAll();
        System.out.println("--- 전체 주문 목록 ---");
        for (Order order : orders) {
            System.out.println("메뉴: " + order.getMenuName() + " | 가격: " + order.getPrice() + "원");
        }
    }
}
