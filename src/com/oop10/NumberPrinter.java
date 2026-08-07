package com.oop10;

public class NumberPrinter {

    int id;
    // int waitNumber; // 대기 번호
    // 인스턴스(객체)들이 공유 할 수 있는 메모리 영역이다. (static)
    static int waitNumber; // static 추가

    public NumberPrinter(int id) {
        this.id = id;
        waitNumber = 1;
    }

    // 번호표 출력 기능
    public void printWaitNumber() {
        System.out.println(id + "번 기기의" + "대기 순번은: " + waitNumber);
        waitNumber++;
    }
}
