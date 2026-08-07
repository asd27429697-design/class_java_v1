package com.oop3;

// 버스 클래스
// 속성과 행위를 설계
// BusMainTest1 (객체를 2개 이상 생성하고 결과 출력 해보기)
public class Bus {
    //(예) 1. 속성
    // 버스 번호
    // 탑승 수
    // 최대 탑승 수
    // 정거장
    // 결제 방법
    // 현재 수익금

    //(예) 2. 행위
    // 카드를 찍게 한다.
    // 승객을 태운다.
    // 승객을 내려준다.
    // 전진, 후진, 좌회전, 우회전

    String name;
     int busNumber;
     String busColor;

     void stop() {
         System.out.println("버스가 정차했습니다");
     }

    void StudentBus() {
        System.out.println(name + " 학생이 버스를 타고 돈을 냅니다");
    }

     void depart() {
         System.out.println("버스가 출발합니다.");
     }


     void showInfo() {
         System.out.println("버스 번호: " + busNumber);
         System.out.println("버스 색: " + busColor);
     }

     // 객체란: 객체와 객체간에 관계를 형성하고 상호작용하게 프로그래밍 하는 것

}