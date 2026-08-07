package com.oop16;

public class FruitMart {

    public static void main(String[] args) {
        // 다형성의 활용 - 하나의 배열에 여러 타입 담기

        Banana[] banana = new Banana[10];
        banana[0] = new Banana();
        banana[1] = new Banana();

        Peach[] peaches = new Peach[3];
        peaches[0] = new Peach();
        peaches[1] = new Peach();
        peaches[2] = new Peach();

        // 결론: 다형성이 없다면 타입별로 배열을 따로 만들어야 한다.
        System.out.println("------------------------------");

//        // 즉, 다형성을 쓰면 부모 타입 배열 하나의 자식들을 모두 담을 수 있다.
//        Fruit[] fruits = new Fruit[4];
//        fruits[0] = new Banana();
//        fruits[1] = new Peach();
//        fruits[2] = new Banana();
//        fruits[3] = new Apple();
//
//        // 만약 사과라면 할인 금액으로 호출 해
//        for (int i = 0; i < fruits.length; i++) {
//            fruits[i].showInfo();
//
//            // 문제 - 타입이 바나나일 때만 할인 메서드를 호출 하시오
//            if (fruits[i] instanceof Banana) {
//                ((Banana)fruits[i]).saleBanana();
//            } else if (fruits[i] instanceof Apple) {
//                ((Apple)fruits[i]).saleApple();
//            }
//        }

        // if else 추가 없이 잘 동작하도록 클래스들을 설계해주세요
    }
}
