package oop_test.ch05;

import java.util.ArrayList;
import java.util.List;

public class MemoryItemDao implements ItemDao{
    List<Item> inventory = new ArrayList<>();

    @Override
    public void insert(Item item) {
        inventory.add(item);
        System.out.println("[아이템 이름] 아이템을 인벤토리에 넣었습니다.");
    }

    @Override
    public List<Item> findAll() {
        return inventory;
    }
}
