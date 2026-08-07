package com.oop16;

public class Fruit {

   protected String name;
   protected int price;

   public void showInfo() {
       System.out.println("상품명: " + name);
       System.out.println("가격: " + price);
   }
    public void sale() {
        System.out.println("이 상품은 할인 대상이 아닙니다");
    }

}
