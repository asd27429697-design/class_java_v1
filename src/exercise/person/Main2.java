package exercise.person;

public class Main2 {

    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 20);
        Student student2 = new Student("홍길동", 20);

        System.out.println(student1.equals(student2));
    }

}
