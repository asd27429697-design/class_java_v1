package com.oop2;

public class FunctionTest2 {

    // 세개의 수를 입력 받아 뺄셈하는 함수를 설계하고 그 값을 반환 하는 함수를 만들어 내자
    static int sub(int a, int b, int c) {
        int result = a - b - c;
        return result;
    }

    // 리턴 키워드가 없는 함수를 만들어 보자.
    // void <- 텅 빈, 값이 업는..
    static void sayHello(String greeting) {
        System.out.println("[[[ " + greeting + "]]] ~~~ 😊😊");
    }

    // 매개변수가 없는 함수를 설계해 보자.
    static int calcSum() {
        // 지역 변수는 가능한 초기화값을 먼저 할당 하자.
        int sum = 0;
        int i;

        for (i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        return sum;
    }




    // 코드의 시작점 (메인 함수) JVM - Stack에 할당 됨
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        // sub(int a, int b, int c)
        // 함수 호출시 들어가는 값을 인수라고 부릅니다.
        int result1 = sub(num1, num2, 10);
        sayHello("안녕 함수야 반가워");
        sayHello("안녕 ~ 홍길동");
       int result2 = calcSum();

        System.out.println("------------------------");
        System.out.println(result1);
        System.out.println(result2);


    }
}
