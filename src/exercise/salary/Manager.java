package exercise.salary;

public class Manager extends FullTimeEmployee{

    private int allowance;

    public Manager(String name, int id, int monthlySalary, int allowance) {
        super(name, id, monthlySalary);
        this.allowance = allowance;
    }

    @Override
    public int calculatePay() {
        return super.calculatePay() + allowance;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("직책 수당: " + allowance + "원");
    }
}
