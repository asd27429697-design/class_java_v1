package com.oop17;

public class Apple extends Fruit{

    public Apple() {
        name = "사과";
        price = 3000;
    }
    // 정률 할인 -= -10퍼센트를 깍는다
    @Override
    public void sale() {
        int discount = price / 10;
        System.out.println("사과 10% 할인 가격: " + price);
    }
}
