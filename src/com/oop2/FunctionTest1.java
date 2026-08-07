package com.oop2;

public class FunctionTest1 {

    // 1. 함수를 설계 해보자.
    // 두개의 점수 값을 인풋값으로 받아서 덧셈을 하고 그 결과를 반환하는 일련에 작업 묶음.
    static int add(int n1, int n2) {
        int result;
        result = n1 + n2;
        // return <== 값을 반환 한다.
        return result;
    }

    // 2. 함수 사용하기 (모양 맞추기)
    // 코드 실행의 시작점 (메인 함수)
    public static void main(String[] args) {
        System.out.println("내가 설계한 함수를 사용해 보자");
        // 함수 이름 호출 그리고 모양 맞추기
      int result1 = add(10, 20);

        System.out.println("result1: " + result1);
    }

}
