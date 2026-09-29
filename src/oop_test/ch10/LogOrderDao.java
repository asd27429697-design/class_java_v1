package oop_test.ch10;

import java.util.ArrayList;
import java.util.List;

public class LogOrderDao implements OrderDao {

    @Override
    public void insert(Order order) {
        System.out.println("[LOG] 주문 요청 - 메뉴: " + order.getMenuName() + ", 결제금액: " + order.getPrice() + "원 (저장하지 않음)");
    }

    @Override
    public List<Order> findAll() {
        System.out.println("[LOG] 조회 요청 - 저장된 내역이 없습니다.");
        return new ArrayList<>();
    }
}