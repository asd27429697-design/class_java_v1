package com.oop10;

public class MemberMain {

    public static void main(String[] args) {
        Member member1 = new Member("손흥민");
        Member member2 = new Member("차범근");

        Member.printTotalMembers();

        Member member3 = new Member("박지성");

        Member.printTotalMembers();

    }
}
