package exercise.salary;

public class PartTimeEmployee extends Employee{

    private int workHours;
    private int hourlyWage;

    public PartTimeEmployee(String name, int id, int hourlyWage, int workHours) {
        super(name, id);
        this.workHours = workHours;
        this.hourlyWage = hourlyWage;
    }

    @Override
    public int calculatePay() {
        return hourlyWage * workHours;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("이번 달 근무 시간: " + workHours + "시간");
    }
}
