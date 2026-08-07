package com.oop15;

public class HouseMainTest {

    public static void main(String[] args) {

        House house = new House("부산시 진구");
        house.showInfo();

        house = null;
        // GC 대상은 House, Room 둘 다 제거의 대상이 된다.
    } // end of main

} // end of class
