package oop_test.ch05;

import java.util.List;

public interface ItemDao {

    void insert(Item item);
    List<Item> findAll();
}
