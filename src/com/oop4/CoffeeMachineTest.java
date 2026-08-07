package com.oop4;

public class CoffeeMachineTest {

    public static void main(String[] args) {
      CoffeeMachine machine1 = new CoffeeMachine(200, 50);
      CoffeeMachine machine2 = new CoffeeMachine(50, 10);

     String result1 = machine1.makeCoffee();
        System.out.println(result1);
        machine1.showInfo();
        machine1.makeCoffee(); // 완성됨
        machine1.makeCoffee(); // 현재 물 상태 값 0ml, 30g
        machine1.makeCoffee(); // x
        machine1.makeCoffee(); // x
        machine1.makeCoffee(); // x
        machine1.showCount();
        // 외부에서 받아야 할때 return값을 쓴다

    } // end of main

} // end of class
