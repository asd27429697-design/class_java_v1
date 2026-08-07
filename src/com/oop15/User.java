package com.oop15;

public class User {

    private int id;
    private String name;
    // 연관관계: user 는 Todo 객체의 주소값을 담을 수 잇는 참조 변수를 가진다.
    private Todo todo;

    public User(int id, String userName) {
        this.id = id;
        this.name = userName;
        // todo는 초기화 하지 않았으므로 null 상태이다.
        // 참저 타입 필드의 기본값은 null 이다.
    }

    // 할 일을 할당 받는 메소드 (연관 관계 형성)
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public void displayMyTest() {
        System.out.println(id + " 번 " + name + "님의 현재 할 일 정보입니다");
        if (todo == null) {
            System.out.println("현재 등록된 할 일이 없습니다");
        } else {
            // 연관된 Todo 객체의 메소드를 호출한다
            todo.showInfo();
        }
    }
}
