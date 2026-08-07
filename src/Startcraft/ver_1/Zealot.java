package Startcraft.ver_1;

public class Zealot {

    private String name; // null
    private int power; // 0
    private int hp;    // 0

    public Zealot(String name) {
        this.name = name;
        this.power = 5;
        this.hp = 80;
    }

    // get
    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }
    public int getHp() {
        return hp;
    }

    // 1. 질럿이 저글링을 공격합니다.
    public void attackZergling(Zergling zergling) {
        if (this.hp <= 0) {
            System.out.println(this.name + " 은 이미 사망하여 공격할 수 없습니다");
            return; // 값을 반환 시키거나 또는 메서드를 즉시 종료 시킬 수 있다.
        }
        System.out.println(this.name + " 이 " + zergling.getName() + "을 공격합니다");
        zergling.beAttacked(this.power);
        // 로직 직접 작성
    }
    // 2. 질럿이 마른을 공격합니다.
    public void attackMarine(Marine marine) {
        System.out.println(this.name + " 이 " + marine + "을 공격합니다");

        // 로직 직접 작성
    }
    // 3. 자기 자신(질럿)이 공격을 당합니다.
    public void beAttacked(int power) {
        if (this.hp <= 0) {
            System.out.println(this.name + " 은 이미 사망한 상태입니다");
            return;
        }
        this.hp -= power;
        System.out.println(this.name + " 이 공격을 당합니다");
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + " 은 사망했습니다");
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
