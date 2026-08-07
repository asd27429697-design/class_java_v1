package com.oop4;

public class CalculatorMain {
    // 두 숫자를 더하는 함수

    // 두 숫자를 빼는 함수

    // 두 숫자를 곱하는 함수

    // 두 숫자를 나누는 함수

    // 짝수 판별 함수

    // 홀수 판별 함수

    static int add(int a, int b) {
        return a + b;
    }

    static int add2(int a, int b) {
        return a - b;
    }

    static int add3(int a, int b) {
        return a * b;
    }

    static double add4(int a, int b) {
        // 방어적 코드
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다");
            return 0;
        }
        // 정수 / 정수 ---> 정수 (소수점 버려짐)
        // (double) 둘 중 하나라도 실수 데이터 타입이여야 소수점을 반환 한다
        return (double) a / b;
    }

    static boolean add5(int number) {
        return number % 2 == 0;
    }

    public boolean add6(int a) {
        return a % 2 != 0;
    }

    // 메인 함수
    public static void main(String[] args) {
        // 위 함수를 설계하고 테스트 코드 작성
        CalculatorMain calculatorMain = new CalculatorMain();
        System.out.println(calculatorMain.add(5, 5));
        System.out.println(calculatorMain.add2(10, 3));
        System.out.println(calculatorMain.add3(8, 5));
        System.out.println(calculatorMain.add4(9, 4));
        System.out.println(calculatorMain.add5(4));
        System.out.println(calculatorMain.add5(7));

        // 테스트용 숫자
        int num1 = 10;
        int num2 = 5;
        int testNumber = 7;

        // 만들어진 함수 테스트
    }

}
