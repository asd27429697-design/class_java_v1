package exercise.person;

import java.util.Objects;

public class Book {

    private String title;
    private int id;

    public Book(String title, int id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public String toString() {
        return "[title = " + title + ", Id = " + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.title.equals(book.title) && this.id == book.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title,id);
    }
}
