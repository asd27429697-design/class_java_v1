package com.oop15;

public class player {

    private String name;

    public player(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("선수이름: " + name);
    }
}
