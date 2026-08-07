package com.oop15;

public class Computer {

    private String brand;

    private Cpu controlUnit;
    private Cpu graphicsCard;

    public Computer(String brand) {
        this.brand = brand;

        this.controlUnit = new Cpu("제어장치");
        this.graphicsCard = new Cpu("그래픽카드");
    }


    public void showInfo() {
        System.out.println(brand + "컴퓨터 입니다");
        controlUnit.use();
        graphicsCard.use();
    }
}
