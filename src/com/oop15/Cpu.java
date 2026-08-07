package com.oop15;

public class Cpu {

    private String model;

    public Cpu(String model) {
        this.model = model;
    }

    public void use() {
        System.out.println(model + "를 사용중입니다");
    }
}
