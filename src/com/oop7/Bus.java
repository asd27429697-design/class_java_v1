package com.oop7;

public class Bus {
    int busNumber;
    int busMoney;

    public Bus(int busNumber, int busMoney) {
        this.busNumber = busNumber;
        this.busMoney = busMoney;
    }

    public void showInfo() {
        System.out.println("버스번호: " + busNumber);
        System.out.println("버스요금: " + busMoney + "원");
    }
}
