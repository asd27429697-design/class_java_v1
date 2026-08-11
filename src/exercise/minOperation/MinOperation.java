package exercise.minOperation;

import java.util.Scanner;

@FunctionalInterface
interface MinOperation1 {
    int num(int x, int y);
}

public class MinOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 숫자: ");
        int a = sc.nextInt();
        System.out.println("첫번째 숫자: ");
        int b = sc.nextInt();

        MinOperation1 num1 = (x,y) -> {
            if (x > y) {
                return y;
            } else {
                return x;
            }
        };
        System.out.println("더 작은 값: " + num1.num(a,b));

    }
}
