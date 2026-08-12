package io.ch02;

import java.io.IOException;

public class KeyboardInputTest {
    // 표준 출력 스트림            아무것도 하지않아도 표준 입출력이 깨진다
    // out - OutputStream - println()
    public static void main(String[] args) throws IOException {
        System.out.println("문자를 입력하세요: ");

        // 표준 입력 스트림 - inputStream (키보드)
        int keyCode = System.in.read();

        System.out.println("반환된 정수 값: " + keyCode);
        System.out.println("문자로 변환 (char): " + (char)keyCode);

        System.err.println("한글은 깨져서 표준 입출력만으로 처리가 힘들다");

    }

}
