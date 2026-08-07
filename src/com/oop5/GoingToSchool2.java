package com.oop5;

// 객체를 사용하고 실행해보는 태스트 측 코드
public class GoingToSchool2 {

    public static void main(String[] args) {
        // 객체를 다양하게 생성해서 동작 시켜보고 상호작용 하는지 확인 해보자.

        Student student = new Student("홍길동", 10000);
        Rise rise = new Rise("김치볶음밥", 250);

        student.eatRice(rise, 3);
        rise.showInfo();

        student.eatRice(rise,500);
        rise.showInfo();



    } // end of main

} // end of class
