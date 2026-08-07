package com.oop9;

public class Warrior {

    private String name;
    private int level;
    private int hp;

    public Warrior(String name) {
        this.name = name;
        level = 1;
        hp = 100;
    }

    // getter 메서드 만들어 보기 (read only 의 성질을 가진다)
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    // setter 메서드 만들어 보자 (단, 필요 하다면 만들어 줄 수 있다)
    // setter <-- 리턴 타입이 void 가 된다. 매개 변수가 선언 되어야 한다.
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        if (level <= 0) {
            System.out.println("0보다 작은 값을 입력할 수 없습니다");
            return;
        }
        this.level = level;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            System.out.println("0보다 작은 값을 입력할 수 없습니다");
            return; // 실행의 제어권 반납
        }
        this.hp = hp;
    }

    // 일반 메서드
    public void levelUp() {
        // 멤버 변수 level 1 증가 , 멤버 변수 hp + 50 증가, 화면에 안내 문구 출력
        level++;
        hp += 50;
        System.out.println(name + "의 현재 레벨은 " + level + "입니다");
    }

}
