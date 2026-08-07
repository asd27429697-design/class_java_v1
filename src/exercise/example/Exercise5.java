package exercise.example;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        // 요구 사항을 확인하고 프로그램을 작성해 보세요
        Scanner sc = new Scanner(System.in);
        System.out.println("성적을 입력하세요");
        int score1 = sc.nextInt();

        if (score1 < 0 || score1 > 100) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        char grade;

        if (score1 >= 90) {
            grade = 'A';
            System.out.println("A학점: 우수한 성적이네요! 계속 좋은 성적 유지하길 바랍니다.");
        } else if (score1 >= 80) {
            grade = 'B';
            System.out.println("B학점: 좋은 성적입니다. 조금만 더 노력하면 A도 가능해요!");
        } else if (score1 >= 70) {
            grade = 'C';
            System.out.println("C학점: 괜찮은 성적이지만, 더 높은 등급을 위해 노력해봅시다.");
        } else if (score1 >= 60) {
            grade = 'D';
            System.out.println("D학점: 학습에 더 집중할 필요가 있어요. 도움이 필요하면 말해주세요.");
        } else  {
            grade = 'F';
            System.out.println("F학점: 불합격입니다. 부족한 부분을 파악하고, 추가 학습이 필요해요.");
        }

        System.out.println("당신의 학점은 " + grade + " 입니다");



    } // end of main

} // end of class
