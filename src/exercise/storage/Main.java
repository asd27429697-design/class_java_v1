package exercise.storage;

public class Main {

    public static void main(String[] args) {
       Book book = new Book();

       Storage<Book> storage = new Storage<>();
       storage.setItem(book);

        System.out.println(storage.getItem());
    }
}
