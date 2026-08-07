package exercise.person;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("홍길동", 20);

        person.setName("김철수");
        person.setAge(30);

        System.out.println(person);
    }
}
