package com.oop9;

public class WarriorMainTest1 {

    public static void main(String[] args) {
        Warrior w1 = new Warrior("광폭전사");
        Warrior w2 = new Warrior("일반전사");
        w1.levelUp();

        // get,set 메서드 확인
        // 필요에 의해서 멤버 변수 상태값을 변경해보자. 객체 상태 변경은 행위(메서드)를 통해서 변경해야 한다.
        w1.setHp(-80);
        w1.setLevel(1);
        w1.setName("작은전사");
        System.out.println("----------------------");
        System.out.println(w1.getHp());
        System.out.println(w1.getLevel());
        System.out.println(w1.getName());









        // Warrior 의 멤버 변수에 접근 제어 지시자는 private 이라 여기에서 접근 불가능?
        // 그러면 외부에서 필요하다면 값을 확을 확인할 수 있는 방법은, 특히 값만
        // getter, setter 메서드를 사용해서 설계해 둘 수 있다. (외부 사용자가 활용해서 쓸 수 있도록)


    } // end of main

} // end of class
