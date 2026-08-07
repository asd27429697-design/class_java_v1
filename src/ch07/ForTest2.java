package ch07;

public class ForTest2 {

    public static void main(String[] args) {
        // 화면에 구구단 2단을 출력하시오
        int num = 2;
        System.out.println(num + " * 1 = " + (num * 1));
        System.out.println(num + " * 2 = " + (num * 2));
        System.out.println(num + " * 3 = " + (num * 3));
        System.out.println(num + " * 4 = " + (num * 4));
        System.out.println(num + " * 5 = " + (num * 5));
        System.out.println(num + " * 6 = " + (num * 6));
        System.out.println(num + " * 7 = " + (num * 7));
        System.out.println(num + " * 8 = " + (num * 8));
        System.out.println(num + " * 9 = " + (num * 9));

        System.out.println("----------------------------------------");
        // 화면에 구구단 3단을 출력하시오
        num = 3;
        System.out.println(num + " * 1 = " + (num * 1));
        System.out.println(num + " * 2 = " + (num * 2));
        System.out.println(num + " * 3 = " + (num * 3));
        System.out.println(num + " * 4 = " + (num * 4));
        System.out.println(num + " * 5 = " + (num * 5));
        System.out.println(num + " * 6 = " + (num * 6));
        System.out.println(num + " * 7 = " + (num * 7));
        System.out.println(num + " * 8 = " + (num * 8));
        System.out.println(num + " * 9 = " + (num * 9));

        System.out.println("----------------------------------------");
        // 화면에 구구단 4단을 출력하시오
        num = 4;
        System.out.println(num + " * 1 = " + (num * 1));
        System.out.println(num + " * 2 = " + (num * 2));
        System.out.println(num + " * 3 = " + (num * 3));
        System.out.println(num + " * 4 = " + (num * 4));
        System.out.println(num + " * 5 = " + (num * 5));
        System.out.println(num + " * 6 = " + (num * 6));
        System.out.println(num + " * 7 = " + (num * 7));
        System.out.println(num + " * 8 = " + (num * 8));
        System.out.println(num + " * 9 = " + (num * 9));

        System.out.println("----------------------------------------");
        // 화면에 구구단 5단을 출력하시오
        num = 5;
        System.out.println(num + " * 1 = " + (num * 1));
        System.out.println(num + " * 2 = " + (num * 2));
        System.out.println(num + " * 3 = " + (num * 3));
        System.out.println(num + " * 4 = " + (num * 4));
        System.out.println(num + " * 5 = " + (num * 5));
        System.out.println(num + " * 6 = " + (num * 6));
        System.out.println(num + " * 7 = " + (num * 7));
        System.out.println(num + " * 8 = " + (num * 8));
        System.out.println(num + " * 9 = " + (num * 9));

        System.out.println("------------------------------------");

        num = 6;

        for (int i = 1; i < 10; i++) {
            // 1. i = 1;
            // 2. i = 2;
            // 3. i = 3;
            // 4. i = 4;
            // 5. i = 5;
            // 6. i = 6;
            // 7. i = 7;
            // 8. i = 8;
            // 9. i = 9;
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        num = 7;
        // 구구단 7단
        for (int i = 1; i < 10; i++) {
            System.out.println(num + " x " + i + "  = " + (num * i));
        }

        num = 8;
        // 구구단 8단
        for (int i = 1; i < 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        num = 9;
        // 구구단 9단
        for (int i = 1; i < 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

    } // end of main
} // end of class
