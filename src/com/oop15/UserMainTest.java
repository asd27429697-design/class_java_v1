package com.oop15;

public class UserMainTest {

    public static void main(String[] args) {

        // 1. Todo 객체와 User 객체는 서로 몰라도 각자 생성이 된다.
        Todo todo1 = new Todo("자바복습");
        User user1 = new User(1, "홍길동");

        // 2. 아직 연결되지 않은 상태 - todo1 필드는 null 상태 임
        user1.displayMyTest();
        System.out.println("------------------------");

        // 3. 연관 간계 형성 - user 가 todo1 의 주소값을 갖게 된다.
        user1.setTodo(todo1);
        user1.displayMyTest();
        System.out.println("------------------------");

        // 4. todo1 참조 변수를 통해서 상태를 바꿔본다 (중요)
        todo1.setCompleted(true);

        // 5. user1을 통해서 조회해봐도 바뀐 상태가 보인다
        // 즉, 복사본이 아니라 같은 객체 하나를 함께 가리키고 있다.
        user1.displayMyTest();


    } // end of main

} // end of class
