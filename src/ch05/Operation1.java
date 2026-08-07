package ch05;

/**
 * 부호 연산자
 * 단항 연산자, 변수에 부호를 변경한다
 * 단, 변수안에 들어가 있는 값의 부호를 변경하려면 대입연산자와 함께 사용해야 한다.
 */

public class Operation1 {

    public static void main(String[] args) {

        int intData = 100;
        System.out.println(+intData);
        System.out.println(-intData);
        System.out.println("-----------------");
        // 주의! 부호 연산자는 실제 변수에 값을 변경하는 개념이 아니다
        System.out.println("intData: "+ intData);

        // 그러면 실제 변수에 값을 변경하려면 대입연산자와 함께 사용해주어야 한다.
        intData = -intData; // 부호 연산자 사용해서 새로 대입하는 개념이다.
        System.out.println("intData: "+ intData);

    } // end of main

} // end of class
