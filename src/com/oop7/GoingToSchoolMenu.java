package com.oop7;

import java.util.Scanner;

// 코드를 실행해 보는 측
public class GoingToSchoolMenu {

    public static void main(String[] args) {

        // 준비물
        Scanner sc = new Scanner(System.in);
        final int FAT = 1;
        final int BUS = 2;
        final int SUBWAY = 3;
        final int MY_INFO = 4;
        final int END = 0;

        System.out.println("학생의 이름을 입력하세요: ");
        String name = sc.nextLine();

        // 객체 생성 (등장인물 준비)
        Student student = new Student("홍길동", 5_000);
        Rice rice = new Rice("김치볶음밥", 3000);
        Bus bus133 = new Bus(133, 1_000);
        Subway line1 = new Subway(1, 1_400);


        while (true) {
            System.out.println();
            System.out.println("메뉴 선택");
            System.out.println("1.밥먹기 2.버스타기 3.지하철타기 4.내상태 5.종료");
            // 직접 실행 흐름 만들어 보기
            int choice = sc.nextInt();

            if (choice == FAT) {
                System.out.println("먹을 밥 양을 입력하세요");
                int amount = sc.nextInt();
                student.eatRise(rice, amount);
            } else if (choice == BUS) {
                student.takeBus(bus133);
            } else if (choice == SUBWAY) {
                student.takeSubway(line1);
            } else if (choice == MY_INFO) {
                student.studentInfo();
            } else if (choice == END) {
                System.out.println("잘못 된 입력입니다. 다시 입력하세요");
            } else {
                System.out.println("종료합니다");
                break;
            }
        }


    } // end of main
} // end of class
