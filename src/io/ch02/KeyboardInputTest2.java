package io.ch02;


import java.io.IOException;

public class KeyboardInputTest2 {

    public static void main(String[] args) throws IOException {
        // in - 한번에 여러 데이터를 받을 수 있는 기능을 구현 (Scanner <-- 대신 표준 입출력 사용)
        System.out.println("알파벳 여려개를 쓰고 enter 를 누르세요");
        int i;
        while ((i = System.in.read()) != '\n') {
            // System.out.println(" i: " + i);
            // System.out.println("문자로 변환: " + (char)i);
            // System.out.println("받은 결과: ");
            System.out.print((char)i);
        }
    }

}
