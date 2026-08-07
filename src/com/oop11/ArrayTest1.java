package com.oop11;

public class ArrayTest1 {

    public static void main(String[] args) {

        // 배열(Array) - 연괸 된 데이터를 모아서 통으로 관리하기 위한 데이터 타입이다.
        // 즉, 변수가 하나의, 데이터를 저장하기 위한 것이라면 배열을 여려개의 데이터를 하나의 변수에
        // 저장하기 위한 것.

        // 문법, 왜
        int[] intArr1 = new int[3]; // [][][]
        int intArr2[] = new int[3]; // [][][]
        // 중요 - 배열 선언이 아닌 사용으로 하려면 반드시 몇 개의 데이터가 들어갈지
        //       배열의 길이를 지정해야 사용 할 수 있다.

        intArr1[0] = 10;
        intArr1[1] = 20;
        intArr1[2] = 30;
        // [10][20][30]
        // intArr1[3] = 40; 오류 발생 배열의 길이를 벗어남

        // 배열 사용방법 2번째
        int[] gradArray = new int[] {1, 2, 3}; // [1][2][3]  <- 잘 안씀
        int[] gradArray2 = {2,3,4}; // new int[] <--- 생략 가능 [2][3][4]  <- 잘 안씀
        // 배열 선언과 동시에 값 까지 초기화

        // 5개의 길이를 가지는 double 타입의 배열을 선언해 보자

        double[] dArr = new double[5]; // [][][][][]
        dArr[0] = 0.1; // [0.1][][][][]
        dArr[1] = 0.2; // [0.1][0.2][][][]

        // tip. 배열의 길이와 인덱스의 크기는 다르다 즉, 인덱스의 크기는 n - 1 이다
        // 배열의 길이가 30, 인덱스 크기는 n - 1 --> 29 (인덱스의 크기)
        // 배열의 길이가 789, 인덱스 크기는 n - 1 --> 788 (인덱스의 크기)
        // 인덱스의 시작은 0번부터 시작한다.

        // 문제 1
        // char 배열 2개 선언해서 초기화 하는 코드 작성
        char[] cArr1 = new char[2];
        cArr1[0] = 'A';
        cArr1[1] = 'B';
        // cArr1[2] = 'B'; 배열에 범위를 벗어남 오류 발생 (런타임시 오류 발생)

        // 문제
        // boolean 배열 3개 선언해서 초기화 하는 코드 작성
        boolean[] bArr1 = new boolean[3];
        bArr1[0] = true; // [true][][]
        bArr1[2] = false; // [true][][false] <- 원하는 상자안에만 작성해도 상관없다






    } // end of main

} // end of class
