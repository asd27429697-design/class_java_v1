package ch01; // 패키지 ch01 폴더 안에 존재하는 파일 임

// 이 파일에 이름은 Variable.java 파일이다.

/**
 * 변수란 뭘까?
 * 변하는 수 (변할 수 있는 데이터)
 * 데이터(값)를 담을 수 있는 메모리 공간(상자)
 */
public class Variable {

    // 프로그램의 시작 점 (실행 시)
    public static void main(String[] args) {
        // 1. 변수의 선언
        int ageBox; // 정수 값을 담을 수 있는 상자를 선언
        int telBox; // 정수 값을 담을 수 있는 상자를 선언

        // 2. 변수에 값을 대입
        ageBox = 30;

        // 3. 변수에 사용
        System.out.println(ageBox); // 화면에 괄호안에 있는 값을 출력하라

        // 4. 변수는 변할 수 있는 수 이다.
        ageBox = 100;

        // 5. 화면에 다시 변수 출력
        System.out.println(ageBox);

    } // end of main

} // end of class
