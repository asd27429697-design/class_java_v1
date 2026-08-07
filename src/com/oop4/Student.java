 package com.oop4;

/**
 * 생성자(constructor)
 *  객체를 생성할 때 다음과 같은 모양으로 객체를 만들어라고 지시하는 것 (강제성)
 *  생성자는 객체를 생성할 때 반드시 존재 해야 한다.
 */
public class Student {

    int id;
    String name;
    int grade;

    // .java -> 컴파일러 --> .class
    // 1. 사용자 정의 생성자를 만들지 않으면 컴파일러가 .class 파일을 생성할 때 자동으로 만들어 준다.
    // 기본 생성자 모양 확인
    // public Student() {}

//    // 2. 사용자 정의 생성자
//    // 문법: 생성자는 '리턴' 타입이없다. 그리고 자바 파일명과 이름이 같아(대소문자까지)
    public Student(int n, String s, int g) {
        // 생성자는 객체를 메모리에 올릴 때(인스턴스화) 가장 먼저 실행되는 코드 이다.
        id = n;
        name = s;
        grade = g;
    }

    public void showInfo() {
        System.out.println("---상태창---");
        System.out.println("학번: "+ id);
        System.out.println("이름: "+ name);
        System.out.println("학년: "+ grade);
    }
}
