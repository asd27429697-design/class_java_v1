package oop_test.ch08;

import java.util.ArrayList;
import java.util.List;

public class MemoryOrderDao implements OrderDao {
    private List<Order> orderList = new ArrayList<>();

    @Override
    public void insert(Order order) {
        orderList.add(order);
        System.out.println(order.getMenuName() + " 주문이 접수되었습니다.");
    }

    @Override
    public List<Order> findAll() {
        return orderList;
    }
}