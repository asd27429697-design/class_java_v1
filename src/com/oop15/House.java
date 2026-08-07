package com.oop15;

public class House {

    private String address;
    // 합성 관계: House는 내부적으로 Room 객체들을 소유한다
    private Room livingRoom;
    private Room bedRoom;

    public House(String address) {
        this.address = address;
        // 합성 조건 1
        this.livingRoom = new Room("거실");
        this.bedRoom = new Room("침실");
    }

    // 합성 조건 2 - Room에 대한 getter 메소드를 만들지 않음

    public void showInfo() {
        System.out.println(address + "에 위치한 집입니다");
        livingRoom.use();
        bedRoom.use();
    }

}
