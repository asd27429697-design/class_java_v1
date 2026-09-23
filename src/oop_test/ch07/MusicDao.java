package oop_test.ch07;

import java.util.ArrayList;
import java.util.List;

public class MusicDao {

    private List<Music> musicList = new ArrayList<>();

    public void insert(Music music) {
        musicList.add(music);
        System.out.println(music.getArtist() + "곡이 플레이리스트에 추가되었습니다.");
    }

    public List<Music> findAll() {
        return musicList;
    }
}
