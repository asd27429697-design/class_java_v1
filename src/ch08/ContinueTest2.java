package ch08;

public class ContinueTest2 {

    public static void main(String[] args) {
        // 1층부터 15층까지 엘리베이터가 올라갑니다.
        // 단, 4층은 미신 때문에 층수를 세지 않고 건너뜁니다.
        for (int i = 1; i <= 15; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i + "층 도착");


        }
    } // end of main
} // end of class
