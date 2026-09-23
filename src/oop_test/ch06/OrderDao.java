package oop_test.ch06;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private List<Order> orderList = new ArrayList<>();

    public void insert(Order order) {
        orderList.add(order);
        System.out.println(order.getMenuName() + "주문이 접수되었습니다");
    }

    public List<Order> findAll() {
        return orderList;
    }

}
