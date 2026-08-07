package com.oop18;

public class DeskTop extends Computer{


    @Override
    public void display() {
        System.out.println("컴퓨터 화면을 출력한다");
    }

    @Override
    public void typing() {
        System.out.println("키보드를 친다");
    }
}
