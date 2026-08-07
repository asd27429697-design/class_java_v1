package ch05;

/**
 *
 * .
 */
public class Operation6 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        //  논리 연산자 (&&, ||, !)
        int num1 = 100;
        int num2 = 200;

        // 1. 논리곱 ( && )
        //                    T    &&  T ---> T
        boolean flag1 = (num1 > 0) && (num2 > 0);
        System.out.println("flag1: " + flag1);
        //                   T     &&       F ---> F      둘다 참이어야지 true나옴
        boolean flag2 = (num1 > 0) && (num2 < 0);
        System.out.println("flag2: " + flag2);

        // 2. 논리합 ( || )
        boolean flag3 = (num1 > 0) || (num2 > 0); // true
        System.out.println("flag3: " + flag3);

        boolean flag4 = (num1 < 0) || (num2 < 0); // false  하나라도 true가 있으면 true
        System.out.println("flag4: " + flag4);

        // 정리
        // 논리 곱 - 둘다 참(true) 일 때 true 반환
        // 논리 합 - 둘중 하나라도 참(true)일 때 true 반환

        // 부정 논리 연사자 확인
        System.out.println(!true); // false    ! <- 부정연산자 반대로 나옴


    } // end of main

} // end of class
