package com.oop7;

public class Student {

    String name;
    int money;

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    void eatRise(Rice rice, int amount) { // 밥 먹기
        boolean eat = rice.eat(amount);
        if (eat) {
            System.out.println(name + "님 " + rice.menuName + "을 먹었습니다.");
        } else {
            System.out.println("밥을 다 먹었습니다 밥이 없습니다.");
        }
    }

    void takeBus(Bus bus) {
        if (money >= bus.busMoney) {
            money -= bus.busMoney;
            System.out.println(bus.busNumber + "번 버스를 타고 요금 " + bus.busMoney + "원을 지불했습니다.");
        } else {
            System.out.println("돈이 부족하여 버스를 탈 수 없습니다.");
        }
    }

    void takeSubway(Subway subway) {
        if (money >= subway.subwayMoney) {
            money -= subway.subwayMoney;
            System.out.println(subway.subwayNumber + "호차를 타기전 요금" + subway.subwayMoney + "원을 지불하고왔습니다.");
        } else {
            System.out.println("돈이 부족하여 지하철을 탈 수 없습니다.");
        }
    }


    public void studentInfo() {
        System.out.println("이름: " + name);
        System.out.println("보유 돈: " + money);
    }
}
