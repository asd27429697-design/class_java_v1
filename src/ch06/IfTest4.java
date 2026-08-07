package ch06;


import java.util.Scanner;

public class IfTest4 {

    public static void main(String[] args) {
        // 키보드에서 값을 받을 도구 준비
        Scanner sc = new Scanner(System.in);
        System.out.println("성적을 입력하세요");
        int score = sc.nextInt();
        char result = 'F';
        // System.out.println("score: " + score);
        // 방어적 코드 작성
        // 사용자가 값을 잘못 입력하는 경우 방어적 코드를 잘 작성해주어야 한다.
        // 0 ~ 100 점 사이값만 받을 예정이다.

        // 조건문을 사용해서 입력 받은 값에 따라 학점을 출력하는 프로그래밍을 만들어 보자.
        // 문제
        // 90점 이상이면 A 출력
        // 80점 이상이면 B 출력
        // 70점 이상이면 C 출력
        // 60점 이상이면 D 출력
        // 59점 이하이면 F 출력

        if (score < 0 || score > 100) {
            System.out.println("잘못된 입력입니다. 다시 프로그램을 실행시키세요");
            // return - 실행의 제어권을 반납한다.
            return;
        }
        if (score >= 90) {
            result = 'A';
        } else if (score >= 80) {
            result = 'B';
        } else if (score >= 70) {
            result = 'C';
        } else if (score >= 60) {
            result = 'D';
        } else if (score <= 59) {
            result = 'F';
        }

        // "당신의 학점은 A 입니다" + 10 +" 입니다"
        System.out.println("당신의 학점은 " + result + " 입니다");


    } // end of main

} // end of class
