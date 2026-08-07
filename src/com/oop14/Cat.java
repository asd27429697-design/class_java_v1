package com.oop14;

public class Cat extends Animal{

    // 어노테이션 (주석 + 힌트)
    @Override
    void eat() {
        System.out.println("고양이가 밥을 먹다");
    }
}
