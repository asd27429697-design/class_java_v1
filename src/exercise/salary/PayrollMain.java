package exercise.salary;

public class PayrollMain {

    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new Manager("박팀장", 1002, 4000000,500000);
        fullTimeEmployee.printInfo();
        System.out.println("급여: " + fullTimeEmployee.calculatePay() + "원");
        System.out.println("보너스: " + fullTimeEmployee.calculateBonus() + "원");
    }
}
