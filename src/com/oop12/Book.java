package com.oop12;

public class Book {

    private String title;
    private String author;
    private int totalPage; // 0
    // 대문자로 시작하는 타입 --> 참조 변수 (null로 초기화 된다)

    // 이 생성자는 외부에서 호출 불가 private 이기 때문에
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int totalPage) {
        this(title, author);
        this.totalPage = totalPage;
    }
    // getter - 읽기만 가능
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void showInfo() {
        System.out.println(">>> 책 정보 <<<");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        if (totalPage != 0) {
            System.out.println("총 페이지 수: " + totalPage);
        }
    }
}
