package com.oop14;

public class Cal {

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int multiply(int n1, int n2) {

        return n1 + n2;
    }

} // end of class

// xxxx.java 하나의 자바 파일에 여러개의 클래스를 사실 선언할 수 있다.(단, 권장하지는 않음)
// 주의점: 단 하나의 자바 파일에는 오직 public 클래스는 하나만 선언할 수 있다. // 문법 약속

class ChildCal extends Cal {

    public int minus(int n1, int n2) {
        return n1 - n2;
    }

    // 부모 클래스의 메소드를 재 정의 할 수 있다. --> 오버 라이딩 (상속 관계에서 사용)
    @Override // 어노테이션 ( 컴파일러에게 알려주는 주석 )
    public int multiply(int n1, int n2) {
        System.out.println("Child 에 multiply() 호출");
        if (n1 == 0 || n2 == 0) {
            System.out.println("0 으로 입력하지 마세요");
        }
        return n1 + n2;
    }

} // end of class

