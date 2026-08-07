package com.oop14;

public class Dog extends Animal{

    @Override
    void eat() {
        super.eat();
        System.out.println("강아지가 밥을 먹다");
    }
}
