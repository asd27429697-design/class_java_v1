package com.oop9;

public class Dog {

    private String name;
    private int age;
    private double weight;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    // 1. get 메서드 만들어 주세요

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    // 2. set 메서드 만들어 주세요

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("0보다 작은 값을 입력 할 수가 없습니다");
        } else {
            this.age = age;
        }
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("0보다 작은 값을 입력 할 수가 없습니다");
        } else {
            this.weight = weight;
        }
    }
}
