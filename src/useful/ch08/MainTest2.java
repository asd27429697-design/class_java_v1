package useful.ch08;

public class MainTest2 {

    public static void main(String[] args) {

        // 외부에서 들어오는 값들은 보통 문자열로 취급하는 경우가 많다. (스캐너, 통신)
        String str1 = "10A"; // 숫자가 아닌 문자 포함
        String str2 = "20.5"; // 실수 형태의 문자열
        String str3 = "true"; // Boolean 형태의 문자열
        int n1;
        try {
            n1 = Integer.parseInt(str1);
            System.out.println(n1 + 100);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값입니다");
        }

        double d = Double.parseDouble(str2);
        System.out.println(d + 0.5);

        boolean b = Boolean.parseBoolean(str3);
        System.out.println(!b);

    } // end of main
} // end of class
