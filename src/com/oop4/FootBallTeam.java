package com.oop4;

public class FootBallTeam {

    String stadiumName;
    int winner;
    int foundedYear;
    String starPlayer;


    void tottenham() {
        System.out.println("---소식---");
        System.out.println(starPlayer + "은 2025년 토트넘을 떠나 이적했다.");
    }

    public FootBallTeam(String stadiumName, int winner, int foundedYear, String starPlayer) {
        this.stadiumName = stadiumName;
        this.winner = winner;
        this.foundedYear = foundedYear;
        this.starPlayer = starPlayer;
    }

    public void Info() {
        System.out.println("스타디움 이름: " + stadiumName);
        System.out.println("우승 횟수: " + winner);
        System.out.println("창단년도: " + foundedYear);
        System.out.println("스타선수: " + starPlayer);
    }
    public void Info2() {
        System.out.println("스타디움 이름: " + stadiumName);
        System.out.println("우승 횟수: " + winner);
        System.out.println("창단년도: " + foundedYear);
        System.out.println("스타선수: " + starPlayer);
    }
}
