package com.oop19;

public class ManualCar extends Car {

    @Override
    protected void drive() {
        System.out.println("사람이 핸들을 직접 조작해서 운전을 합니다");
    }

    @Override
    protected void stop() {
        System.out.println("사람이 브레이크를 밟아서 정지 합니다");
    }
}
