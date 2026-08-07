package com.oop14;

public class CMainTest {

    public static void main(String[] args) {

        C c = new C();
        // 물려 받기는 하지만 접근 제어 지시자에 따라서 접근을 할 수 있거나 못할 수 도 있다.

        c.age = 10;
        c.height = 100;
        c.weight = 200;

        c.level = 1;
        c.nickName = "C";

        System.out.println(c.age);
        System.out.println(c.height);
        System.out.println(c.weight);

    } // end of main

} // end of class
