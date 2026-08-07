package com.oop10;

public class Account {
    int accountNumber; // 계좌번호
    String ownerName; // 예금주
    int balance; // 잔액

    public Account(String ownerName, int balance) {
        this.ownerName = ownerName;
        this.balance = balance;

        this.accountNumber= Bank.baseAccountNumber;
        Bank.baseAccountNumber++;


    }
}
