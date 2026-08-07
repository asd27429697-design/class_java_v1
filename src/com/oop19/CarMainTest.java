package com.oop19;

public class CarMainTest {

    public static void main(String[] args) {

        Car car1 = new AICar();
        Car car2 = new ManualCar();

        car1.run(); // 실행의 흐름이 정해져 있다.
        System.out.println("---------------------");
        car2.run();

    } // end of main
} // end of class
