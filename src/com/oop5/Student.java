package com.oop5;

public class Student {

    String name;
    int money;


    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // 메서드1. 학생이 버스를 탄다.
    void takeBus(Bus bus) {
        // 자기의 일은 직접 스스로 해결 한다.
        bus.take(1000);
        money -= 1000;
    }

    // 메서드2. 힉생이 지하철을 탄다
    void takeSubway(Subway subway) {
        subway.take(500);
        money -= 500;
    }

    // 메서드3. 학생이 밥을 먹는다. (남은 양이 없으면 밥 못 먹었습니다)
    public void eatRice(Rise rice, int amount) {
       // rice.eat(100); ---> true or false
        if (rice.eat(100)){
            System.out.println(name + "님 " + rice.menu + "을 먹었습니다");
        } else {
            System.out.println("밥을 다 먹었거나 양이 부족해서 먹질 못했습니다");
        }
    }

    // 메서드2. 정보창 보여 주는 기능
    public void showInfo() {
        System.out.println(name + "님의 현재 남은 금액: " + money);
    }
}
