package com.oop17;

public class Main {

    public static void main(String[] args) {

        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Banana();
        fruits[1] = new Peach();
        fruits[2] = new Apple();

        // 타입 검사가 필요 없다. 새로운 과일 타입이 추가 되더라도 굳이 if문을 작성할 필요 조차 없다.
        for (int i = 0; i < fruits.length; i++) {
            fruits[i].showInfo();
            fruits[i].sale();
            System.out.println("-------------------");
        }

    } // end of main

} // end of class
