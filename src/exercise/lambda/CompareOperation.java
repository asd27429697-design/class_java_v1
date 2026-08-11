package exercise.lambda;

import java.util.Scanner;

@FunctionalInterface

interface Compare {
    boolean compare(int x, int y);
}
// 두 정수를 입력받아서 두 수가 같은지 확인하는 프로그램

public class CompareOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 숫자");
        int x = sc.nextInt();
        System.out.println("첫번째 숫자");
        int y = sc.nextInt();

        Compare compare1 = (a, b) -> a == b;
        System.out.println(compare1.compare(x,y));
    }
}
