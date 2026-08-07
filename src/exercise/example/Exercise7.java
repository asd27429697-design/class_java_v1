package exercise.example;

public class Exercise7 {

    //함수 만들기1
    public static void Greet(String name) {
        System.out.println("안녕하세요 " + name + "님!");
    }
    //함수 만들기2
     static int square(int a) {
        int result = a * a;
        return result;
     }

    //함수 만들기3
    public static String signOfNumber(int b) {
        if (b > 0) {
            return "positive";
        } else if (b < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    //함수 만들기4
    public static boolean checkAdult(int age) {
        return age >= 18;
    }

    //함수 만들기5
    static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 코드의 시작점 (메인 함수)
    public static void main(String[] args) {
        Greet("손흥민");

        int result2 = square(5);
        int result3 = square(10);
        System.out.println("5의 제곱: " + result2);
        System.out.println("10의 제곱: " + result3);

        String result4 = signOfNumber(2);
        String result5 = signOfNumber(-1);
        String result6 = signOfNumber(0);
        System.out.println("positive: " + result4);
        System.out.println("negative: " + result5);
        System.out.println("zero: " + result6);

        System.out.println("checkAdult(20): " + checkAdult(20));
        System.out.println("checkAdult(18): " + checkAdult(18));
        System.out.println("checkAdult(17): " + checkAdult(17));

        System.out.println("findMax(3, 7) = " + findMax(3, 7));
        System.out.println("findMax(10, 2) = " + findMax(10, 2));
        System.out.println("findMax(5, 5) = " + findMax(5, 5));
        System.out.println("findMax(-3, -8) = " + findMax(-3, -8));


    } // end of main


} // end of class
