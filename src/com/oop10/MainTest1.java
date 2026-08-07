package com.oop10;

public class MainTest1 {

    public static void main(String[] args) {

        Employee emp1 = new Employee("홍길동", "개발팀");
        Employee emp2 = new Employee("이순신", "개발팀");
        Employee emp3 = new Employee("유관순", "경영팀");

        System.out.println(emp1.employeeNumber); // 1001
        System.out.println(emp2.employeeNumber); // 1002
        System.out.println(emp3.employeeNumber); // 1003

    } // end of main

} // end of class
