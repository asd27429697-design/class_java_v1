package com.oop4;

public class MainTest3 {
    public static void main(String[] args) {
        FootBallTeam footBallTeam = new FootBallTeam("토트넘 핫스퍼 스타디움",
                27, 1882, "손흥민");
        FootBallTeam footBallTeam1 = new FootBallTeam("산티아고 베르나베우", 36, 1902, "음바페");
        System.out.println("--- 토트넘 핫스퍼 ---");
        footBallTeam.Info();
        footBallTeam.tottenham();
        System.out.println("--- 레알 마드리드 ---");
        footBallTeam1.Info2();
    }
}
