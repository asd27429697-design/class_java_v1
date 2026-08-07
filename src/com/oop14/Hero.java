package com.oop14;

public class Hero {

    String name;
    int hp;

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    void attack() {
        System.out.println("기본 공격하고 있습니다");
    }
}
