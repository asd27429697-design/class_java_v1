package ch06;

public class IfTest2 {

    // 코드 실행의 시작점(메인함수)
    public static void main(String[] args) {
        // 만약 ...이라면 if else 구문

        // if (조건식) {...} else {...}
        int age = 2;

        if (age >= 19) {
            System.out.println("성인입니다");
        } else {
            System.out.println("아직어린이입니다");
        }
        // 두가지 경우 중 반드시 하나는 수행이 된다
        System.out.println("=== 프로그램을 종료합니다 ===");

    } // end of main

} // end of class
