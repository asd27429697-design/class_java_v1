package com.oop18;

public class Person extends Human{
    // 오류, 추상, Person을 일반 구현 클래스로 만들어 주세요


    @Override
    public void hunt() {
        System.out.println("사람이 도끼로 사냥을 합니다");
    }

    public static void main(String[] args) {
        Animal animal = new Person();
        animal.hunt();
    }
}
