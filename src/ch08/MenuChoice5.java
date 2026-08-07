package ch08;

import java.util.Scanner;

public class MenuChoice5 {
    // CRUD
    // 변수 name 을 사용해서 CRUD 구현을 해보자
    public static void main(String[] args) {
        // 준비물
        Scanner sc = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;
        String name = "";
        boolean isOk = false;

        while (true) {
            System.out.println("\n메뉴선택");
            System.out.println("1.등록 2.조회 3.수정 4.삭제 0.종료");
            System.out.print("선택 : ");
            int choice = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비

            if (choice == CREATE) {
                if (isOk) {
                    System.out.println("이미 등록되어 있습니다: " + name);
                } else {
                    System.out.println("등록을 선택했습니다");
                    System.out.print("등록할 이름을 입력하세요: ");
                    name = sc.nextLine();
                    isOk = true;
                }

            } else if (choice == READ) {
                if (isOk) {
                    System.out.println("조회 결과 : " + name);
                } else {
                    System.out.println("조회할 이름이 없습니다");
                }
            } else if (choice == UPDATE) {
                if (isOk) {
                    System.out.println("수정을 선택했습니다");
                    name = sc.nextLine();
                    System.out.println("수정한 이름: " + name);
                } else {
                    System.out.println("수정 불가");
                }

            } else if (choice == DELETE) {
                if (isOk) {
                System.out.println(name + "삭제를 했습니다");
                    name = "";
                    isOk = false;
                } else {
                    System.out.println("삭제 불가");
                }
            } else if (choice == END) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("**잘못된 입력입니다. 다시 선택해주세요**");
            }

        }
        sc.close();
    } // end of main

} // end of class
