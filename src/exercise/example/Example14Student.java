package exercise.example;

public class Example14Student {

    String name;
    int age;
    public Example14Student() {
        this.name = "이름없음";
        this.age = 0;
    }

    public Example14Student(String name) {
        this.name = name;
        this.age = 0;
    }

    public Example14Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println(name + "의 나이는 " + age + "살 입니다");
    }
}
