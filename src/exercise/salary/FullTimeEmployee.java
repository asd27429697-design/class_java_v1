package exercise.salary;

public class FullTimeEmployee extends Employee implements Bonusable{

   private int monthlySalary;

    public FullTimeEmployee(String name, int id, int monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public int calculatePay() {
        return monthlySalary;
    }

    @Override
    public int calculateBonus() {
        return monthlySalary * 2;
    }
}
