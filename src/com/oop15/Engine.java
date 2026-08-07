package com.oop15;

public class Engine {

    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println(name + "엔진이 가동됩니다");
    }

    public void stop() {
        System.out.println(name + "이 정지합니다");
    }
}
