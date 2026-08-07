package exercise.person;

public class Student {

    private String name;
    private int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "[name = " + name + ", id = " + studentId + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.name.equals(student.name) && this.studentId == student.studentId;
        }
        return false;
    }
}
