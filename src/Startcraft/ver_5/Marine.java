package Startcraft.ver_5;

public class Marine extends Unit implements Attackable{

    public Marine(String name) {
        super.name = name;
        super.power = 4;
        super.hp = 70;
    }


    @Override
    public void specialAttack() {
        System.out.println(this.name + "이 특수공격을 합니다");
    }
}