package exercise.salary;

public class PayableMain {

    public static void main(String[] args) {
        Employee employee1 = new FullTimeEmployee("김정규", 1001, 3200000);
        Employee employee2 = new PartTimeEmployee("이알바", 2001, 10030, 80);
        employee1.printInfo();
        System.out.println("급여: " + employee1.calculatePay() + "원");
        System.out.println("-------------");
        employee2.printInfo();
        System.out.println("급여: " + employee2.calculatePay() + "원");


    }
}
