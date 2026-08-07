package com.oop19;

// final 클래스 앞에 작성 되어 있으면 상속 불가
public abstract class Car {

    // final private String NAME; 변수에 final을 사용하면 상수가 된다

    private void startCart() {
        System.out.println("시동을 켭니다");
    }

    private void turnOff() {
        System.out.println("시동을 끕니다");
    }

    protected abstract void drive();

    protected abstract void stop();

    // 핵심: 이 메서드를 템플릿 메서드로 설계 하겠다
    // 실행의 흐름이 미리 정의 되어 있다. - 반드시 final 키워드를 선언해 준다.
    final public void run() {
        startCart(); // 1. 시동걸기
        drive(); // 2. 운전 하기
        stop(); // 3. 정지 하기
        turnOff(); // 4. 시동 끄기
    }
    // >>  메서드 final 정의하면 즉, 제 정의 불가 오버라이드 불가
}
