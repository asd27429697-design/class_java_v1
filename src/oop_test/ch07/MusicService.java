package oop_test.ch07;

import java.util.ArrayList;
import java.util.List;

public class MusicService {

    private MusicDao musicDao;

    public MusicService(MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public void addMusic(String title, String artist) {
        Music music = new Music(title, artist);
        musicDao.insert(music);
    }

    public void printPlayList() {
        List<Music> list = musicDao.findAll();
        System.out.println("--- 플레이리스트 목록 ---");
        for (Music music : list) {
            System.out.println("곡명: " + music.getTitle() + " | 가수: " + music.getArtist());
        }
    }

}
