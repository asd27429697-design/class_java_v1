package exercise.phone;

public class Developer extends Employee{

    String language;

    public Developer(String name, int salary, String language) {
        super(name, salary);
        this.language = language;
    }

    @Override
    public void work() {
        System.out.println(name + " 이" + language + "개발을 합니다");
    }
}
