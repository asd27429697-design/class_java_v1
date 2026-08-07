package com.oop3;

public class BusMainTest1 {
    public static void main(String[] args) {
        Bus b1 = new Bus();

        b1.name = "홍길동";
        b1.busColor = "노란색";
        b1.busNumber = 402;

        b1.stop();
        b1.StudentBus();
        b1.depart();
        b1.showInfo();
    }
}
