package exercise.salary;

public abstract class Employee implements Payable{

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void printInfo() {
        System.out.println("[" + id + "] " + name);

    }
}
