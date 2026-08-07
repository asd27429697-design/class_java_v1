package ch03;

public class ConstantTest3 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
    // 사각형의 면적을 구하는 코드를 작성해 보세요, 단 상수 활용
        // 가로 * 세로

//        System.out.println(5 * 5);
//        System.out.println(5 + 5);

        final double WIDTH = 11.5;
        final int height = 10;

        double area = WIDTH * height;

        System.out.println("사각형의 면적: " + area);







    } // end of main

} // end of class
