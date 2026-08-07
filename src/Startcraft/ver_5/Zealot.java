package Startcraft.ver_5;

public class Zealot extends Unit implements Attackable{

    public Zealot(String name) {
        super.name = name;
        super.power = 5;
        super.hp = 80;
    }

    @Override
    public void specialAttack() {
        System.out.println(this.name + "이 특수공격을 합니다");
    }
}