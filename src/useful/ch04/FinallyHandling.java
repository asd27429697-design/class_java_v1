package useful.ch04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyHandling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("숫자를 입력하시오");
            int result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("입력을 잘못했음 (숫자임)");
        } catch (Exception e2) {
            System.out.println("알 수 없는 오류 발생");
        } finally {
            // 반드시 수행되어야 할 코드 영역
            // 심지어 return 키워드를 만나더라도 여기는 수행이 됩니다.
            scanner.close();
        }



        System.out.println("-----------------------");
        System.out.println("프로그램이 비정상 종료 안됨");

        // scanner.close(); // 메모리 누수 방지

    } // end of main
} // end of class
