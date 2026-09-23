package oop_test.ch02;

public class Main {

    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        boardService.writePost("첫 번째 글입니다","자바 객체지향 연습을 하고 있습니다.");
    }
}
