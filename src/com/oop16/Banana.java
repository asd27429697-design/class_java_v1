package com.oop16;

public class Banana extends Fruit{

    public Banana() {
        name = "바나나";
        price = 5_000;
    }

    // 정액 할인 - 1000원을 깍는다.
    @Override
    public void sale() {
        price -= 1000;
        System.out.println("할인된 바나나 가격 : " + price);
    }
}
