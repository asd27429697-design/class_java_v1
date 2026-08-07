package com.oop5;

// 객체를 사용하고 실행해보는 태스트 측 코드
public class GoingToSchool {

    public static void main(String[] args) {

        Bus bus133 = new Bus(133);
        Bus bus57 = new Bus(57);
        Student kim = new Student("홍길동", 10000);
        Student lee = new Student("이순신", 5000);
        // 밥 메모리에 생성 - 직접 실행 흐름 만들어서 테스트


        kim.takeBus(bus133);
        lee.takeBus(bus133);

        kim.showInfo(); // kim 현재 소지금 확인
        lee.showInfo(); // lee 현재 소지금 확인
        System.out.println("--------------------------");
        bus133.showInfo();

    } // end of main

} // end of class
