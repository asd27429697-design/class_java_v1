package ch01;

/**
 * 여러줄 주석
 * ctrl + alt + L <-- 코드 정렬 단축키
 * <p>
 * 프로그래밍 세상과의 첫 인사
 * 화면에 문자열 Hello World를 출력하기
 */
public class HelloWorld {
    // <-- 한줄 주석 (컴파일러가 무시하는 영역 입니다)
    public static void main(String[] args) {
        System.out.println("Hello World"); // 명령어의 끝은 세미콜론으로 알려준다.
        System.out.println(); // 출력 후 다음 줄로 넘어가는 역할을 합니다(line feed)
        // 화면에 숫자 0부터 9까지 화면에 출력해
        System.out.println(0); //ctrl + d (해당 줄 복사)
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);

    } // end of main

} // end of class
