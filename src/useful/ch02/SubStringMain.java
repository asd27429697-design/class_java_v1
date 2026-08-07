package useful.ch02;
/**
 * substring() 메서드 개념
 * substring() 메서드는 String 객체에서 원하는 위치의 문자열
 * 일부를 추출하여 새로운 문자열로 반환하는 메서드이다.
 * 문자열의 인덱스(위치)를 기준으로 원하는 범위의 문자를 가져올 수 있으며,
 * 원본 문자열은 변경되지 않는다. (String은 불변 객체이기 때문)
 *
 * 특징
 * 인덱스는 0부터 시작한다.
 * substring(int beginIndex)는 지정한 시작 위치부터 문자열 끝까지 반환한다.
 * substring(int beginIndex, int endIndex)는 시작 위치부터 endIndex - 1 위치까지 반환한다.
 * endIndex 위치의 문자는 포함되지 않는다.
 */

public class SubStringMain {

    public static void main(String[] args) {

        String str = "Java Programming";

        String result1 = str.substring(5);
        System.out.println(result1);

        String result2 = str.substring(0, 4);
        System.out.println(result2);

        System.out.println(str);
    } // end of main
} // end of class
