package com.oop16;

public class Tiger extends Animal{

    @Override // 주석 + 힌트
    public void move() {
        System.out.println("호랑이가 살금살금 움직입니다");
    }

    public void hunting() {
        System.out.println("호랑이가 뒤에서 사냥을 합니다");
    }
}
