package com.oop10;

public class NumberPrinterTest2 {

    public static void main(String[] args) {

        // NumberPrinter printer1 = new NumberPrinter(1);
        // NumberPrinter printer2 = new NumberPrinter(2);
        // static 변수는 모든 객체가 공유하는 변수를 만들 때 사용할 수 있다.
        // static 변수는 심지어 객체를 생성하기 전에도 먼저 사용할 수 있다.
        // 그래서 클래스 변수라고 부른다.
        System.out.println(NumberPrinter.waitNumber);
        System.out.println(NumberPrinter.waitNumber);
        // tip - static 은 태양이다.



    } // end of main

} // end of class
