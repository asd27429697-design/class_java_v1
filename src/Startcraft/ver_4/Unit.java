package Startcraft.ver_4;

public class Unit {

    protected String name;
    protected int power;
    protected int hp;

    // getter
    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }
    public int getHp() {
        return hp;
    }

    // 모든 유닛 공격
    public void attack(Unit unit) {

        if (this.hp <= 0) {
            System.out.println(name + "이 사망하여 공격할 수 없습니다");
            return;
        }
        System.out.println(name + "이" + unit.getName() + "을 공격합니다.");
       unit.beAttacked(this.power);
    }

    // 공격을 당했다.
    public void beAttacked(int power) {
        if (this.hp <= 0) {
            System.out.println(name + "이(가) 사망하여 공격할 수 없습니다");
            return;
        }
        this.hp -= power;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(name + "이(가) 공격을 당합니다. (남은 HP : " + this.hp + ")");
    }

    // 상태창
    public void showInfo() {
        System.out.println("★---상태창---★");
        System.out.println("유닛 이름 : " + name + " | 공격력 : " + power + " | 체력 : " + hp);
    }
}
