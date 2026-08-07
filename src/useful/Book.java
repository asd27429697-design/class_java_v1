package useful;

//import java.lang.String;
//import java.lang.*;    <--- 자동으로 가지고 오는 녀석이라 직접 명시할 필요가 없다.
// Object 클래스는 모든 클래스의 최상위 클래스이다.
// extends Object 를 선언하지 않아도 자동 생성 됨
public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
