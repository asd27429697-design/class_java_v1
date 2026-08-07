package Startcraft.ver_1;

public class Zergling {

    private String name; // null
    private int power; // 0
    private int hp;    // 0

    public Zergling(String name) {
        this.name = name;
        this.power = 3;
        this.hp = 50;
    }

    // get 메서드
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }
    // 1. 저글링이 질럿을 공격합니다.
    public void attackZealot(Zealot zealot) {
        if (this.hp <= 0) {
            System.out.println(this.name + " 은 이미 사망하여 공격할 수 없습니다");
            return; // 값을 반환 시키거나 또는 메서드를 즉시 종료 시킬 수 있다.
        }
        System.out.println(this.name + " 이 " + zealot.getName() + "을 공격합니다");
        zealot.beAttacked(this.power);
    }
    // 2. 저글링이 마린을 공격합니다.
    public void attackMarine(Marine marine) {
        System.out.println(this.name + " 이 " + marine + "을 공격합니다");
        marine.beAttacked(this.power);
    }
    // 3. 자기 자신(저글링)이 공격을 당합니다.
    public void beAttacked(int power) {
        if (this.hp <= 0) {
            System.out.println(this.name + "은 이미 사망한 상태입니다");
            return;
        }
        this.hp -= power;
        System.out.println(this.name + " 이 공격을 당합니다");
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + "은 사망했습니다");
        }
    }
    // 4.  내 현재 상태 출력(콘솔) 기능 만들기
    public void showInfo() {
        System.out.println("------상태창------");
        System.out.println("이름: " + name);
        System.out.println("현재 공격력: " + power);
        System.out.println("현재 생명력: " + hp);
    }
}
