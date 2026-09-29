package oop_test.ch08;

import java.util.List;

// 인터페이스 (설계도)
public interface OrderDao {
    void insert(Order order);
    List<Order> findAll();
}
