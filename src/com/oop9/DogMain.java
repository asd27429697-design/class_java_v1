package com.oop9;

public class DogMain {

    public static void main(String[] args) {
        Dog dog = new Dog("흰둥이", 5, 20);

        dog.setName("검둥이");
        dog.setAge(-2);
        dog.setWeight(42);
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.getWeight());
    }
}
