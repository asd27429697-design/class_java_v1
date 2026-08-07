package exercise.phone;

public class Employee {

    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " 이 업무를 시작합니다");
    }
}
