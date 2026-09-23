package oop_test.ch05;

public class Item {

    private String name;
    private String grade;

    public Item (String name, String grade)  {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}
