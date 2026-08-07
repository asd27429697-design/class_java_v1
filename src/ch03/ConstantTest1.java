package ch03;

public class ConstantTest1 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        int num = 10;
        num = 101;

        // 상수 사용해 보기
        // final 키워드 사용하고 변수명에 이름을 작성할 때 대문자 _(언더바) 를 사용하는게
        // 권장사항이다.
        final int MAX_NUM = 100; // 한번 값이 정해지면 다시 변경할 수 없다. (상수)
        // MAX_NUM = 1;

        // 원주율을 상수로 선언해 보자.
        final double PI = 3.14159;
        final int RADIUS = 5;

        // 준비물 :
        // 원에 둘레를 계산해보자 (계산 공식 찾아 보기) - 2 * PI * 반지름
        // 원에 면적을 계산해보자 (계산 공식 찾아 보기) - 반지름 * 반지름 * PI

        double permiter = 2 * PI * RADIUS;
        System.out.println("원의 둘레: " + permiter);

        double area = RADIUS * RADIUS * PI;
        System.out.println("원의 면적: " + area);


    } // end of main

} // end of class
