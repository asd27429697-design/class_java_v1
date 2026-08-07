package com.oop16;

public class InstanceOfTest {

    public static void main(String[] args) {

        Fruit fruit1 = new Peach();
        Fruit fruit2 = new Banana();
        checkFruit(fruit1);
        System.out.println("------------");
        checkFruit(fruit2);


    } // end of main

    public static void checkFruit(Fruit fruit) {
        // 캐스팅하기(형변환) 전에 반드시 확인한다
        if (fruit instanceof Banana) {
            System.out.println("바나나입니다");

            // 여기 안에서 다운 캐스팅은 안전하다.
//            Banana banana = (Banana) fruit;
//            System.out.println("원산지: " + banana.getOrigin());
//            banana.saleBanana();
        } else if (fruit instanceof Peach) {
            System.out.println("복숭아 타입입니다");
        } else {
            System.out.println("알 수 없는 과일입니다");
        }
    }

} // end of class
