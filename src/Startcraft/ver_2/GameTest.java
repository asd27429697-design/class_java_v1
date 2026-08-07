package Startcraft.ver_2;

public class GameTest {

    public static void main(String[] args) {
        // 질럿이 저글링은 공격하는 시나리오
        Zealot z1 = new Zealot("질럿1");
        Zergling ze1 = new Zergling("저글링1");
        Zergling ze2 = new Zergling("저글링2");

//        for (int i = 0; i < 10; i++) {
//            z1.attackZergling(ze1);
//        }
//        ze1.showInfo();
        System.out.println("---------------------");

        // 저글링이 질럿을 공격합니다
        for (int i = 0; i < 100; i++) {
            ze2.attack(z1);
        }
        z1.showInfo();
    } // end of main

} // end of class
