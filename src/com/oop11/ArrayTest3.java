package com.oop11;

public class ArrayTest3 {

    // 코드의 시작점
    public static void main(String[] args) {

        char[] alpahbets = new char[26];
        char ch1= 'A';
        alpahbets[0] = ch1;

        char ch2 = 'B';
        alpahbets[1] = ch2;

        char ch3 = 'C';
        alpahbets[2] = ch3;

        char ch26 = 'Z';
        alpahbets[25] = ch26;

//        System.out.println(alpahbets[0]);
//        System.out.println(alpahbets[1]);
//        System.out.println(alpahbets[2]);
//        System.out.println(alpahbets[3]);

        // 배열은 반복문과 함께 많이 사용이 된다.
        int forCount = 0;
        for (int i = 0; i < alpahbets.length; i++) {
            System.out.println(alpahbets[i]);
            forCount++;
        }
        System.out.println();
        System.out.println("for 동작 횟수: " + forCount);

        // 배열에 길이와 요소의 개수는 동일하지 않을 수 있다.




    } // end of main
} // end of class
