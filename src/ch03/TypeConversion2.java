package ch03;

/**
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경 하는 것
 * - 자동 형변환, 강제 형변환
 */
public class TypeConversion2 {

    // 코드의 시작점
    public static void main(String[] args) {
        // 자동 형변환 코드 작성해보기
        // 강제 형변환 코드 작성해보기
        // 결과 출력해 보기

        int num1 = 5000;
        double num2;

        num2 = num1;
        System.out.println("num2: " + num2);

        double num3 = 14.5787878;
        int num4;

        num4 = (int) num3;
        System.out.println("num4: " + num4);

    } // end of main

} // end of class
