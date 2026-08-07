package com.oop14;

public class ChildCalMainTest {

    public static void main(String[] args) {

        ChildCal childCal = new ChildCal();

        System.out.println(childCal.sum(10,10));
        System.out.println(childCal.multiply(10,0)); // 오버라이드 된 메소드
        System.out.println(childCal.minus(100,1));

        // 상황 1
        // 곱하기 기능에 n1과 n2에 0이 들어온다면 0을 입력하지 마시오
        // 코드 수정 요청이 들어 옴.

        // 답) 메소드 오버라이드 활용

    } // end of main

} // end of class
