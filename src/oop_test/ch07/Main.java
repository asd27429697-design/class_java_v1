package oop_test.ch07;

public class Main {

    public static void main(String[] args) {
        MusicDao musicDao = new MusicDao();

        MusicService musicService = new MusicService(musicDao);

        musicService.addMusic("팔레트", "아이유");
        musicService.addMusic("Love Attack", "리센느");
        musicService.addMusic("SuperNova", "에스파");

        musicService.printPlayList();
    }
}
