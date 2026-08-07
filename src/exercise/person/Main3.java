package exercise.person;

public class Main3 {

    public static void main(String[] args) {
        Book book1 = new Book("자바의 정석", 1001);
        Book book2 = new Book("자바의 정석", 1001);
        Book book3 = new Book("스프링 입문", 1002);

        System.out.println(book1);
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));
        System.out.println("-------------------------");
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
    }
}
