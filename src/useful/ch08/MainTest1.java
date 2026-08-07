package useful.ch08;

public class MainTest1 {

    public static void main(String[] args) {

        // 1단계: 박싱과 언박싱을 직접 호출해서 확인해보자.
        int num = 3;
        Integer num2 = Integer.valueOf(3); // 박싱: int --> Integer 객체
        int num3 = num2.intValue();           // 언박싱: Integer ---> int

        System.out.println(num2);
        System.out.println(num3);

        // 자바 5버전 부터 자동 박싱, 자동 언박싱을 제공하고 있음

        // 2단계: 자동 박싱 / 자동 언박싱
        Integer num4 = 17; // 자동 박싱: 컴파일러가 Integer.valueOf(17); 변환 함.
        int num5 = num4;   // 자동 언박싱: 컴파일러가 num4.intValue(); 로 변환 함.

    } // end of main
} // end of class
