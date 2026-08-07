package exercise.example;

public class Example07 {
    public static void main(String[] args) {

        int num = 1;

        while (num <= 100) {
            if (num % 7 == 0) {
                System.out.println(num);
            }
            if (num == 49) {
                System.out.println("멈춤");
                break;
            }
            num++;
        }

        System.out.println("--------------------");

        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }
            if (i >= 40) {
                System.out.println("종료");
                break;
            }
        }

    }
}
