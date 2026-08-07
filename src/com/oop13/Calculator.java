package com.oop13;

// 메소드 오버로딩: 같은 이름의 메소드를 여러개 정의하는 것을 말한다.
public class Calculator {

    // 정수형 덧셈 메소드
    public int add(int a, int b) {
        return a + b;
    }

    // 실수형 덧셈 메소드
    public double add(double a, double b) {
        return a + b;
    }

    // 세 정수의 덧셈 메소드
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // println 메소드 오버로딩 기법이다
        System.out.println(1);
        System.out.println(1.0);
        System.out.println(true);
        System.out.println("String");



        // 메소드 오버로딩 기법이 없다면 아마 이렇게 호춣해야 되었을 겁니다.
//        printlnInt()
//        printLnDouble()
//        printlnBoolean()
//        printlnString()


    } // end of main

} // end of class
