package ch07;

public class WhileTest2 {

    public static void main(String[] args) {
        // 특정 조건이 생길 때 반복문을 종료 시킬 수 있다.
        boolean flag = true; // 깃발
        int start = 0;
        final int END = 50;

        while (flag) {
            start++;
            System.out.println("start: " + start);
            if (start == END) {

                System.out.println("프로그램을 종료합니다");
                flag = false; // 만약 start 값이 50이라면 flag라는 변수에 접근해서 값을 false로 변경하게 된다.
            }
        }

    } // end of main
} // end of class
