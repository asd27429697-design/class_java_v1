package com.oop11;

public class ArrayTest4 {

    // 코드의 시작점
    public static void main(String[] args) {


        // 문자열로 배열을 사용해보자.

        String[] names = new String[10];

        // 인덱스 연산자를 활용하여 값을 초기화
        names[0] = "김씨";
        names[1] = "나씨";
        names[2] = "박씨";
        names[3] = null;
        names[9] = "최씨";
        // 배열에 길이와 요소의 개수는 동일하지 않다.
        // 요소만 출력하도록 수정해 주세요
        for (int i = 0; i < names.length; i++) {
            // 만약 null이 아니라면 출력해
            if (names[i] != null) {
                System.out.println(names[i]);
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.println(i);
            }
        }

    } // end of main
} // end of class
