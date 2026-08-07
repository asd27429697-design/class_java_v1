package Startcraft.ver_4;

public class GameTest {

    public static void main(String[] args) {

        Unit[] units = new Unit[3];
        units[0] = new Zealot("질럿1");
        units[1] = new Marine("마린1");
        units[2] = new Zergling("저글링1");

        units[0].attack(units[1]);
        units[2].attack(units[1]);
        System.out.println("--------------------");
        units[1].beAttacked(30);
    }




}
