package ch01;

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

    @Override
    public String toString() {
        return "["+ title + "," + author+ "]";
    }
    
    // showInfo <--- 대신 활용 가능

    public static void main(String[] args) {

        Book book = new Book("데미안", "헤르만헤세");
        Book book2 = book;
        Book book3 = new Book("데미안", "헤르만헤세");
        System.out.println(book == book2); // true
        System.out.println(book.equals(book2)); // equals 기본 동작은 == 이다. true
        System.out.println(book);
        System.out.println("----------------------");
        System.out.println("로깅 1: 책의 제목: " + book.title);

        // 논리적으로 같은 객체라고 판별하고 싶을 때 equals() 메서드를 재 정의해서 활용할 수 있다.
        // 단, equals() 재정의 할 때 반드시 해시코드도 함께 재정의 해야 된다.

        System.out.println(book.hashCode());
    }
}
