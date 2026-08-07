package com.oop5;

public class Subway {

    int lineNumber;
    int count;
    int money;

    // 1. 생성자
    public Subway(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    // 2. 승객을 태운다
    void take(int pay) {
        money += pay;
        count++;
    }

    // 3. 정보 보기
    public void showInfo() {
        System.out.println("호선: " + lineNumber);
        System.out.println("현재 승객 수: " + count);
        System.out.println("현재 수익 금액: " + money);
    }
}
