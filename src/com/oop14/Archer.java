package com.oop14;

public class Archer extends Hero{


    public Archer(String name, int hp) {
        super(name, hp);
    }

    void fireArrow() {
        System.out.println("궁수 불화살을 쏩니다");
    }
}
