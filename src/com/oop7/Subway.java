package com.oop7;

public class Subway {
    int subwayNumber;
    int subwayMoney;

    public Subway(int subwayNumber, int subwayMoney) {
        this.subwayNumber = subwayNumber;
        this.subwayMoney = subwayMoney;
    }

    public void showInfo() {
        System.out.println("호차: " + subwayNumber);
        System.out.println("요금: " + subwayMoney + "원");
    }
}
