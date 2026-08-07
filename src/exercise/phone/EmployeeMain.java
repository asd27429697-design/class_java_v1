package exercise.phone;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("홍길동", 10000000);
        employee.work();
        Developer developer = new Developer("홍길동", 10000000, "한국어");
        developer.work();
    }
}
