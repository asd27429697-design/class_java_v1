package exercise.example;

public class Example11 {
    public static void main(String[] args) {
        // 이중 for 구문을 활용해서 출력 하시오
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j<= 2; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        // 별표 찍기 (이중 for 구문을 활용한 코드를 작성해주세요)
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("------------------------------");

        // 별표 찍기 (이중 for 구문을 활용한 코드를 작성해주세요)
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("------------------------------");


        // 별표 찍기 (이중 for 구문을 활용한 코드를 작성해주세요)
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



    }
}
