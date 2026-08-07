package ch05;

/**
 * 관계 연산자(비교 연산자)
 * 연산에 결과는 true, false로 반환 된다.
 */
public class Operation5 {

    // 매인 함수
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;

        //                  5     3
        boolean result1 = num1 > num2; // true
        System.out.println("result1: " + result1);

        System.out.println(num1 > num2); // true
        System.out.println(num1 < num2); // false
        System.out.println(num1 >= num2); // true
        System.out.println(num1 <= num2); // false
        System.out.println(num1 == num2); // false
        System.out.println(num1 != num2); // true     != <- 같지않다는 뜻




    } // end of main

} // end of class
