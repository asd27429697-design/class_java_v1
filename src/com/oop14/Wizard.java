package com.oop14;

public class Wizard extends Hero{


    public Wizard(String name, int hp) {
        super(name, hp);
    }

    void freezing() {
        System.out.println("마법사가 얼음마법을 씁니다");
    }
}
