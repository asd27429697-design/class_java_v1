package com.oop6;

public class Account {

    private String name;
    private int balance;

    // 입금하다
    public void deposit(int money) {
        balance += money;
        System.out.println("입금완료");
    }

    // 출금하다
    public int withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("출금완료");
            return money;
        } else {
            System.out.println("잔액 부족");
            return 0;
        }

    }

    // 현재 잔액 표시
    public void showInfo() {
        System.out.println("현재잔액: " + balance + "원");
    }
}
