package ch05;

/**
 * 증감, 감소 연산자 ++, --
 * 부호연산자와 다르게 변수에 직접 접근해서 오직 1증가, 감소를 시키는 연산자이다.
 */
public class Operation4 {
    // 매인 함수
    public static void main(String[] args) {
        int value = 1;
        // 증감 연산자
        value++;
        System.out.println("value = " + value);
//        value = value + 1;
//        value += 1;
//        value++;

        // 감소 연산자
        int value2 = 1;
        value2--;
        System.out.println("valie2 = " + value2);
        System.out.println("------------------------------");

        // 2.1 - 증감 연산자가 항 앞에 올 경우 (전위연산자) ++10;
        // 2.2 - 증감 연산자가 항 뒤에 올 경우 (후위연산자) 10++;

        // 증감 전위 연산자 사용
        int data1 = 10;
        int temp1 = ++data1;
        System.out.println("temp1: " + temp1);

        // 증감 후위 연산자 사용
        int data2 = 10;
        int temp2 = data2++;
        System.out.println("temp2: " + temp2);
        // 증감 후위 연산자를 사용할 때 변수에 접근해서 값이 1증가 되는것은 맞음, 단 ;(세미콜론이 끝난 이후)

        // 항이 하나 있을 때 확인
        int data3 = 10;
        int data4 = 10;
        ++data3;
        data4++;
        System.out.println("data3: " + data3);
        System.out.println("data4: " + data4);

        // 반복문을 제외하고 전위 연산자를 사용하는게 권장사항

        // 문제 1. 전위 감소 연산자, 후위 감소 연산자를 사용하고 결과를 출력 하시오.

        int num1 = 20;
        int num2 = 20;

        int temp3 = --num1;

        int temp4 = num2--;

        System.out.println("temp3: " + temp3);
        System.out.println("temp4: " + temp4);

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);


    } // end of main

} // end of class
