package com.oop4;

// 코드를 실행하는 측 파일
public class MainTest1 {

    // 코드의 시작점
    public static void main(String[] args) {
        // Student s2 = new Student(); // 기본 생성자를 사용해서 객체 생성 됨.
        // 주의! 만약 단 하나의 사용자 정의 생성자를 만들었다면 기본 생성자는
        // 자동으로 생성되지 않는다. !!
        Student s1 = new Student(1, "야스오", 2);
        s1.showInfo();

        // 생성자 - 객체를 생성시키는 특별한 유형에 함수이다.

    } // end of main
} // end of class
