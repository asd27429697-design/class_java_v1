package com.oop10;

public class PhoneMain {

    public static void main(String[] args) {
        Phone phone1 = new Phone("갤럭시");
        Phone phone2 = new Phone("아이폰");
        Phone phone3 = new Phone("샤오미");

        System.out.println(phone1.serialNumber);
        System.out.println(phone2.serialNumber);
        System.out.println(phone3.serialNumber);
    }
}
