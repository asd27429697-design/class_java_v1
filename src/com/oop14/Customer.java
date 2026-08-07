package com.oop14;

public class Customer {

    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    protected int bonusPoint;
    protected double bonusRatio;

    public Customer() {
        customerGrade = "일반고객";
    }

    public int calcPrice(int price) {
        return price;
    }

    public String showCustomerInfo() {
        System.out.println(customerName + "님의 등급은" + customerGrade + "입니다");
        return customerGrade;
    }
}
