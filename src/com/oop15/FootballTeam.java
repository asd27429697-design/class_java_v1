package com.oop15;

public class FootballTeam {

    private player[] players;
    private int playerCount;

    public FootballTeam(int size) {
        this.players = new player[size];
        this.playerCount = 0;
    }

    public void addPlayer(player player) {
        if (playerCount >= players.length) {
            System.out.println("더 이상 선수를 영입할 수 없습니다");
            return;
        }
        players[playerCount] = player;
        playerCount++;
    }

    public void showPlayer() {
        System.out.println("=== 선수명단 ===");
        for (int i = 0; i < playerCount; i++) {
            players[i].showInfo();
        }
    }
}
