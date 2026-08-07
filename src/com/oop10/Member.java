package com.oop10;

public class Member {

    static int memberCount = 0;
    String name;

    public Member(String name) {
        this.name = name;
        memberCount++;
    }

    public static void printTotalMembers() {
        System.out.println("현재 총 회원 수: " + memberCount + "명");

    }
}
