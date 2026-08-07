package com.oop10;

public class BankMain {
    public static void main(String[] args) {
        Account account1 = new Account("홍길동", 20000);
        Account account2 = new Account("손흥민", 40000);
        Account account3 = new Account("박지성", 30000);

        System.out.println(account1.accountNumber);
        System.out.println(account2.accountNumber);
        System.out.println(account3.accountNumber);

    }
}
