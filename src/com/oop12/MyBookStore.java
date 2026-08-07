package com.oop12;

import java.util.Scanner;

/**
 * 모든 프로그래밍의 기본은 C(Create) R(Read) U(Update) D(Delete) 이다
 * 배열을 활용한 간단한 데이트 관리 시스템
 */
public class MyBookStore {

    // 현재 저장된 실제 데이터 개수를 추럭하는 공유 변수(static)
    static int lastIndexNumber = 0;

    // 전체 조회 하기
    public static void readAll(Book[] books) {
        System.out.println("------------ 전체조회 호출 됨 --------------");
        if (lastIndexNumber == 0) {
            System.out.println("아직 저장된 책이 없습니다");
            return;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {

                System.out.println(books[i].getTitle() + ", " + books[i].getAuthor());
            }
        }
    }
    // 전체 삭제 하기
    public static void deleteAll(Book[] books) {
        System.out.println("------- 전체 삭제 하기 --------");
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }
        // 다시 기준 값 전체 삭제 후 0으로 초기 되어야 함
        lastIndexNumber = 0;
    }

    // 저장 하기
    public static void save(Scanner sc, Book[] books) {
        System.out.println("-------- 저장하기 호출 됨 -------------");

        if (lastIndexNumber >= books.length) {
            System.out.println("저장 공간이 가득 찼습니다");
            return;
        }

        System.out.println("책의 제목을 입력하세요");
        String title = sc.nextLine();
        System.out.println("책의 저자를 입력하세요");
        String author = sc.nextLine();

        Book book = new Book(title, author);
        books[lastIndexNumber] = book;
        lastIndexNumber++;
    }

    // 선택 조회
    public static void searchByTitle(Scanner sc, Book[] books) {
        System.out.println("-------- 선택조회 호출 됨 -----------");
        System.out.println("조회할 책 제목을 입력해주세요");
        String targetTitle = sc.nextLine();

        boolean isFine = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                // 문자열 비교는 반드시 equals() 사용
                // .trim() <-- 문자열에 앞뒤 공백 자동 제거
                // 공백사피 엔스공백
                if (books[i].getTitle().equals(targetTitle.trim())) {
                    System.out.println(" [검색 결과 확인] ");
                    books[i].showInfo();
                    isFine = true;
                    break;
                }
            }
        }
        //  isFine -> true or false
        // isFine -> true --> false
        // if (isFine == false) {
        if (!isFine) { // 단독 if -> true 실행 / 반대로 false -- ! 부정
            System.out.println("조회된 책 결과가 없습니다");
        }
    }

    // 도전 과제 1
    // 선택 삭제 하는 기능
    public static void selectDelete(Scanner sc, Book[] books) {
        System.out.println("--------선택 삭제 하기---------");
        if (lastIndexNumber == 0) {
            System.out.println("삭제할 책이 없습니다");
            return;
        }
        System.out.println("삭제할 책 제목을 입력해주세요");
        String targetTitle = sc.nextLine().trim(); // 키보드에서 입력 값을 받는 동시에 앞뒤 공백 제거
        // 1단계: 삭제할 책의 위치(인덱스)를 먼저 찾는다
        int targetIndex = -1; // -1 "못 찾았다"는 뜻으로 약속한 값
        for (int i = 0; i < lastIndexNumber; i++) {
            if (books[i] != null && books[i].getTitle().equals(targetTitle)) {
                targetIndex = i;
                break;
            }
        }
        // 2단계: 못 찾았으면 여기서 동작 끝
        if (targetIndex == -1) {
            System.out.println("해당 제목의 책을 찾을 수 없습니다");
            return;
        }

        System.out.println("[삭제대상]");
        books[targetIndex].showInfo();

        // 3단계: 삭제할 자리 뒤에 있는 요소들을 한 칸씩 앞으로 당겨서 삭제할 대상 덮어 쓰기
        // [A][B][C][D] ---> 1 인덱스 삭제 ---> [A][C][D][D]
        for (int i = targetIndex; i < lastIndexNumber - 1; i++) {
            books[i] = books[i + 1];
            // [B] ---> 1번째 인덱스 = [C] ---> 2번째 인덱스 를 덮어 쓰기
        }

        // 4단계: 맨 뒤 칸을 비우고 실제 개수를 하나 줄인다 (라이스 인덱스 번호 재 갱신)
        // [A][C][D][D]
        books[lastIndexNumber - 1] = null;
        lastIndexNumber--; // 관리하고 있는 인덱스 번호 -1 처리
    }


    // 메인 함수
    public static void main(String[] args) {
        // 준비물
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100];

        // 샘플 데이터 만들어 놓기
        books[0] = new Book("플러터UI실전", "김근호");
        books[1] = new Book("무궁화꽃이피었습니다", "김진명");
        books[2] = new Book("흐르는강물처럼", "파울로코엘료");
        books[3] = new Book("리딩으로리드하라", "이지성");
        books[4] = new Book("사피엔스", "유발하라리");

        // 샘플 데이터가 5가 이므로 인덱스 관리 번호로 사용
        lastIndexNumber = 5;

        boolean flag = true;

        final String SAVE = "1";
        final String SEARCH_ALL = "2";
        final String SEARCH_BY_TITLE = "3";
        final String DELETE_ALL = "4";
        final String TITLE_DELETE = "5";
        final String END = "0";

        // 2단계 실행의 흐름 만들어 보기
        while (flag) {
            System.out.println("** 메뉴 선택 **");
            System.out.println("1.저장 2.전체조회 3.선택조회 4.전체 삭제 5.선택 삭제 0.종료");
            String selectedNumber = sc.nextLine();

            if (selectedNumber.equals(SAVE)) {
                save(sc, books);
            } else if (selectedNumber.equals(SEARCH_ALL)) {
                readAll(books);
            } else if (selectedNumber.equals(SEARCH_BY_TITLE)) {
                searchByTitle(sc, books);
            } else if (selectedNumber.equals(DELETE_ALL)) {
                deleteAll(books);
            } else if (selectedNumber.equals(TITLE_DELETE)) {
                selectDelete(sc, books);
            } else if (selectedNumber.equals(END)) {
                System.out.println(">> 프로그램 종료");
                flag = false;
            } else {
                System.out.println(">>> 잘못된 선택입니다 <<<");
            }
        }


        // 전체 조회 기능 (R)
        // 저장 기능 (C)
        // 수정 기능 (L)
        // 전체 삭제 기능 (D)


        // 심화
        // 선택 조회 기능
        // 선택 삭제 기능


    } // end of class
}