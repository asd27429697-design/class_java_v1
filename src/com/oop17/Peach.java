package com.oop17;

public class Peach extends Fruit{

    public Peach() {
        name = "복숭아";
        price = 8000;
    }
    // sale() 를 재정의 하지 않았다
    // 부모의 기본 동작인 "할인 대상이 아닙니다"가 실행된다.
}
