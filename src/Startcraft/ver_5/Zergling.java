package Startcraft.ver_5;

public class Zergling extends Unit implements Attackable{


    public Zergling(String name) {
        super.name = name;
        super.power = 3;
        super.hp = 50;
    }

    @Override
    public void specialAttack() {
        System.out.println(this.name + "이 특수공격을 합니다");
    }
}