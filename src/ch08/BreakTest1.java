package ch08;

public class BreakTest1 {

    public static void main(String[] args) {

        // 중간에 멈추는 break 구문
        // 만약 i값이 7이라면 중간에 멈추어라
        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i);
            if (i == 7) {
                break;
            }
        }

        System.out.println("-----------------------");
        // 문제 1. 100 ~ 200 까지 화면에 출력하는 코드를 작성하시오.
        //     2. 단 151 도달 했다면 반복문을 멈추는 코드를 작성하시오.
        //     3.  while 구문을 사용해서

        int i = 100;

        while (i < 200) {
            System.out.println(i);
            if (i == 151) {
                System.out.println("멈춤");
                break;
            }
            i++;
        }

        System.out.println("--------------------");

        int num = 100;

        while (num < 800) {
            System.out.println(num);
            if (num == 500) {
                System.out.println("멈춤");
                break;
            }
            num++;
        }

    } // end of main
} // end of class
