package useful.ch02;

public class ReplaceMain1 {

    public static void main(String[] args) {
        // 개념 정리 - replace는 문자열 안에서 특정 문자나 문자열을 찾아
        // 다른 값으로 바꾼 새로운 문자열을 반환하는 메서드이다
        // 1. 원본은 절대 바뀌지 않습니다.
        // 2. 두 가지 메서드 오버로딩이 존재 한다.

        // 1. char 하나를 다른 char 로 바꾸기
        String fruit = "Banana";
       String result1 = fruit.replace('a','o');
        System.out.println("result1: " + result1 + " 원본: " + fruit);

        // 2. 문자열 단위로 바꾸기
        String phone = "010-1234-1234";
        String result2 = phone.replace("-", "");
        System.out.println("result2: " + result2);

        // 3. 활용
        String sentence = "자바는 재미있다. 또는 자바는 어렵기도 하다";
        String result3 = sentence.replace("자바", "JAVA");
        System.out.println("result3: " + result3);


    } // end of main


} // end of class
