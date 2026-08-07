package Startcraft.ver_2;
public class Marine {

    private String name;
    private int power;
    private int hp;

    public Marine(String name) {
        this.name = name;
        this.power = 4;
        this.hp = 70;
    }

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

    // 저글링 공격
    public void attack(Zergling zergling) {
        if (this.hp <= 0) {
            System.out.println(name + "이(가) 사망하여 공격할 수 없습니다");
            return;
        }
        System.out.println(name + "이(가)" + zergling.getName() + "을 공격 합니다.");
        zergling.beAttacked(this.power);
    }

    // 질럿 공력
    public void attack(Zealot zealot) {
        if (this.hp <= 0) {
            System.out.println(name + "이(가) 사망하여 공격할 수 없습니다");
            return;
        }
        System.out.println(name + "이(가)" + zealot.getName() + "을 공격 합니다.");
        zealot.beAttacked(this.power);
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