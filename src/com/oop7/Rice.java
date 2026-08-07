package com.oop7;

public class Rice {
    String menuName;
    int amount;

    public Rice(String menuName, int price) {
        this.menuName = menuName;
        this.amount = amount;
    }

    boolean eat(int eatAmount) {
        if (amount >= eatAmount) {
            amount -= eatAmount;
            return true;
        } else {
            return false;
        }
    }

    public void showInfo() {
        System.out.println("메뉴이름: " + menuName);
        System.out.println("남은 양 " + amount + "g");
    }
}
