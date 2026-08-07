package com.oop8;

import com.oop6.Bank;

public class Book {

    private String title;
    private String author;
    private int price;

    public Book(String title) {
        this.title = title;
        System.out.println("1번 생성자 호출 됨");
    }

    public Book(String title, String author) {
        // this.title = title;
        this(title);
        this.author = author;
        System.out.println("2번 생성자 호출 됨");
    }

    public Book(String title, String author, int price) {
        this(title, author);
        this.price = price;
        System.out.println("3번 생성자 호출 됨");
    }

    public Book getBook() {
        return this; // 자기 자신의 주소값을 반환 함
    }
}
