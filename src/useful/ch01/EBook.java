package useful.ch01;

import java.util.Objects;

public class EBook {

    private int bookTypeId;
    private String title;
    private String author;

    public EBook(int bookTypeId, String title, String author) {
        this.bookTypeId = bookTypeId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "EBook[" + bookTypeId + ", " + title + ", " + author + " ]";
    }

    // equals() 메서드의 재정의 목적은: 필요하다면 논리적으로 같은 객체라고 판별하고 싶은 때 사용
    @Override
    public boolean equals(Object obj) {
        // 1. 동일 참조 체크
        if (this == obj) {
            return true;
        }
        // 2. 타입 체크 (EBook 인지 여부)
        if (!(obj instanceof EBook)) {
            return false;
        }
        // 3. 필드 비교 (논리적 기준)
        EBook other = (EBook) obj; // 다운 캐스팅
        return  this.bookTypeId == other.bookTypeId &&
                Objects.equals(this.title, other.title) &&
                Objects.equals(this.author, other.author);

    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTypeId, title, author); // 필드 기반으로 해시코드 생성
    }
    // 같이 재정의 해야 의도한 대로 잘 동작 함
}
