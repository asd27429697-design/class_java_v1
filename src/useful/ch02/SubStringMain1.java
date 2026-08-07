package useful.ch02;

public class SubStringMain1 {

    public static void main(String[] args) {
        // 개념 정리 - SubString은 문자열의 일부 구간을 잘라내어 새로운 문자열을
        //             반환하는 메서드이다.
        // H e l l o w o r l d
        // 0 1 2 3 4 5 6 7 8 9
        String text = "HelloWorld";

        // 1. 시작 위치부터 끝까지 자르기
        System.out.println("subString(5): " + text.substring(5));
        // 2. 시작 위치부터 끝 위치 '앞' 까지
        System.out.println("subString(0,5): " + text.substring(0,5));
        // 3. 만들어 져 있는 모양 맞추기 개념 확인

        // 시작인덱스 포함, 끝 인덱스는  포함 안한다.
        // end = start =
        // 6 - 2 = 4
        System.out.println("subString(2,6): " + text.substring(2,6));

        // 주의할 점
        // System.out.println("subString(0,20): " + text.substring(0,20));


    } // end of main
} // end of class
