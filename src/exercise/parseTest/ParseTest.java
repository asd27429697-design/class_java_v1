package exercise.parseTest;

public class ParseTest {

    public static void main(String[] args) {

        String s1 = "50";
        String s2 = "3.5";
        String s3 = "false";
        String s4 = "ABC";

        int n1;
        n1 = Integer.parseInt(s1);
        System.out.println(n1 + 100);

        double d = Double.parseDouble(s2);
        System.out.println(d * 2);

        boolean b = Boolean.parseBoolean(s3);
        System.out.println(!b);

        try {
            int num = Integer.parseInt(s4);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        }




    }

}
