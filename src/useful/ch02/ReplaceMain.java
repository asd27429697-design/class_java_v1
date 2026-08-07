package useful.ch02;

public class ReplaceMain {

    public static void main(String[] args) {
        // String replace(char oldChar, char newChar)
//   문자열에서 모든 oldChar 문자를 newChar로 변경한 새로운 문자열을 반환합니다.
//   변경할 문자가 없으면 원래 문자열 객체를 반환합니다.
//   String replace(CharSequence target, CharSequence replacement)
//   문자열에서 지정한 문자열(target)을 replacement 문자열로 모두 변경합니다.
//   앞에서부터 순서대로 치환하며, 정규표현식이 아니라 문자 그대로(literal) 비교하여 변경합니다.
        {
            String str = "Java Programming";
            String result1 = str.replace('a', 'o');
            System.out.println(result1);
            String result2 = str.replace("Programming", "Study");
            System.out.println(result2);
            System.out.println(str);
        }

    } // end of main


} // end of class
