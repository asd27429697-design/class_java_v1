package com.oop16;

public class FruitMainTest {

    public static void main(String[] args) {

        // 하나의 객체를 다양한 타입으로 바라볼 수 있다.
        Fruit fruit1 = new Banana(); // 업캐스팅된 상태
        Fruit fruit2 = new Peach();

        fruit1.showInfo();
        System.out.println("-----------------------");
        fruit2.showInfo();

        // 문제: 바나나의 원산지 정보는 어떻게 출력할까?
        // fruit1.getOrigin(); 컴파일 에러 - fruit 타입에서 getOrigin() 메서드가 없다

        // 해결방안: 다운 캐스팅으로 컴파일러의 시선을 Banana로 바꾼다.
        //  String result = ((Banana) fruit1).getOrigin();
        //  System.out.println("바나나 원산지: " + result);

        // 하지만 이런 코드는 위험하다. 컴파일을 통과하지만 실제 객체가 다르다면
        // ClassCastException 발생할 수 있음.

    } // end of main
} // end of class
