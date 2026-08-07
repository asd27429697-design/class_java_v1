package com.oop5;

public class Rise {

    String menu;
    int amount; // 남은 양

    public Rise(String menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    // 먹은 만큼 줄어든다. 성공하면 true, 실패하면 false 반환 리턴 값 설계
    boolean eat(int eatAmount) {
        if (amount >= eatAmount) {
            amount -= eatAmount;
            return true;
        } else {
            return false;
        }
        // showInfo
    }

    public void showInfo() {
        System.out.println("메뉴: " + menu);
        System.out.println("남은 양: " + amount + "g");
    }
}
