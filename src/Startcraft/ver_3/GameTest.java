package Startcraft.ver_3;

public class GameTest {

    public static void main(String[] args) {

        Marine marine = new Marine("마린");
        marine.showInfo();

        Zealot zealot = new Zealot("질럿");
        zealot.showInfo();

        Zergling zergling = new Zergling("저글링");
        zergling.showInfo();

        marine.attack(zealot);
    }




}
