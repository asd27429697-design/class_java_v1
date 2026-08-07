package ch05;

/**
 * 부호 연산자
 * 단항 연산자, 변수에 부호를 변경한다
 * 단, 변수안에 들어가 있는 값의 부호를 변경하려면 대입연산자와 함께 사용해야 한다.
 */

public class Operation2 {
    // 매인 함수
    public static void main(String[] args) {
        System.out.println(5 + 3);
        System.out.println(5 - 3);
        System.out.println(5 * 3);
        System.out.println(5 / (double)3); // 결과 1이 나온 이유? (1.66666..) -> int => int 떨어지고 소수점 버려 짐
        System.out.println(5 % 3); // 2

        // 문제
        // 1. (12 + 3) / 3을 화면에 출력해 보세요, 단 결과값을 변수에 담아서 출력

        double num = (12 + 3) / 3;
        System.out.println("(12 + 3) / 3 = " + num);

        // 2. (25 % 2)값을 화면에 출력해보세요

        int num1 = (25 % 3);
        System.out.println("(25 % 2) = " + num1);
        // 나머지 연산자는 해당하는 값이 홀수인지 짝수이지 판별할 때 유용하다
        // 어떤 수를 2로 나누었을 때 나머지가 0이면 짝수라고 판별이 됨 1이면 홀수라고 판별할 수 있다.

        // 3. 7896456 값이 홀수인지 짝수인지 화면에 1 또는 0으로 표시하는 코드를 출력하세요
        int num3 = 7896456;
        System.out.println(num3 % 2); // 0이면 짝수로 판단할 수 있다.


    } // end of main

} // end of class
