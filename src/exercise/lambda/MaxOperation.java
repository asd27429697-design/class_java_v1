package exercise.lambda;

import java.util.Scanner;

@FunctionalInterface
interface Max {
    int num(int x, int y);
}

public class MaxOperation {
// 두 정수를 입력받아서 더 큰 숫자를 반환하는 람다 (Scanner 사용)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자");
        int x = sc.nextInt();
        System.out.println("두 번째 숫자");
        int y = sc.nextInt();

        Max max = (n1,n2) -> {
            if (n1 > n2) {
                return n1;
            } else {
                return n2;
            }
        };
        System.out.println(max.num(x, y));
    }
}
