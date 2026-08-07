package ch08;

public class ContinueTest3 {

    public static void main(String[] args) {
        // 369 게임! 1부터 30까지 세되,
        // 3, 6, 9, 들어간 숫자는 "짝!" 이라고 외칩니다.
        // 13, 16, 19,
        // 23, 26, 29
        for (int i = 1; i <= 30; i++) {

            int last = i % 10;

            if (last == 3 || last == 7 || last == 9) {
                System.out.println("짝!");
                continue;
            }

            System.out.println(i);



            // i 값에 끝자리를 구하는 식을 작성하고 변수 int last 에 담아 주세요
            // 만약 끝자리가 3, 6, 9 라면 화면에 짝! 이라고 출력 하시오

            // 1, 2, 4, 5, ,7, ... 369를 제외하고 화면에 출력 되어야 한다.
        }

        // 샘플 테스트 코드
        // 나머지 연산자와 10이라는 숫자를 활용하면 끝 자리를 추출할 수 있다.
        System.out.println(23 % 10); // 23 / 10 = 2 나머지는 3
        System.out.println(47 % 10); // 47 / 10 = 4 나머지는 7
        System.out.println(39 % 10); // 47 / 10 = 3 나머지는 9
        System.out.println(338 % 10); // 47 / 10 = 33 나머지는 8

        int num = 1;

        while (num <= 20) {
            num++;

            if (num == 6 || num == 12 || num == 18) {
                continue;
            }
            if (num == 20) {
                System.out.println("멈춤");
                break;
            }
            System.out.println(num);
        }



    } // end of main
} // end of class
