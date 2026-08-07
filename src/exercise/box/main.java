package exercise.box;

public class main {

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setValue("안녕하세요");
        System.out.println(box.getValue());

    }
}
