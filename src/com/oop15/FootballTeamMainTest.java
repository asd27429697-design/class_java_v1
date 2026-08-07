package com.oop15;

public class FootballTeamMainTest {

    public static void main(String[] args) {

        player player1 = new player("손흥민");
        player player2 = new player("박지성");
        player player3 = new player("이강인");

        FootballTeam footballTeam = new FootballTeam(3);

        footballTeam.addPlayer(player1);
        footballTeam.addPlayer(player2);
        footballTeam.addPlayer(player3);

        footballTeam.showPlayer();
    }
}
