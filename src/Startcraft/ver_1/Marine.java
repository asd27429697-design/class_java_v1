package Startcraft.ver_1;

public class Marine {
    private String name; // null
    private int power; // 0
    private int hp;    // 0

    public Marine(String name) {
        this.name = name;
        this.power = 4;
        this.hp = 70;
    }

    // get 만들어 주기

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    // 1. 마린이 저글링을 공격합니다.
    public void attackZergling(Zergling zergling) {
        if (hp < 0) {
            System.out.println(this.name + "이 사망했습니다");
            return;
        }
        System.out.println(this.name + " 이" + zergling.getName() + "을 공격했습니다");
        zergling.beAttacked(this.power);
    }

    // 2. 마린이 질럿을 공격합니다.
    public void zealotAttack(Zealot zealot) {
        if (hp < 0) {
            System.out.println(this.name + "이 사망했습니다");
            return;
        }
        System.out.println(this.name + " 이" + zealot.getName() + "을 공격했습니다");
        zealot.beAttacked(this.power);
    }

    // 3. 자기 자신(마린)이 공격을 당합니다.
    public void beAttacked(int power) {
        if (this.hp <= 0) {
            System.out.println(this.name + " 은 이미 사망했습니다");
            return;
        }
        this.hp -= power;
        System.out.println(this.name + "이 공격당하고 있습니다");
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + "은 사망했습니다");
        }
    }

    // 4. 내 현재 상태 출력(콘솔) 기능 만들기
    public void showInfo() {
        System.out.println("---상태창---");
        System.out.println("이름: " + this.name);
        System.out.println("현재 공격력: " + this.power);
        System.out.println("현재 체력: " + this.hp);
    }

}
