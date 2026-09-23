package oop_test.ch02;

public class BoardService {
    BoardDao boardDao = new BoardDao();

    public void writePost(String title, String content) {
        Board board = new Board(title, content);
        boardDao.insertPost(board);
    }
}
