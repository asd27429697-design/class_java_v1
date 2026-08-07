package useful.ch07;

public class Plastic extends Material{

    @Override
    public String toString() {
        return "재료는 플라스틱입니다";
    }

    @Override
    public void showInfo() {
        System.out.println("재료는 플라스틱");
    }
}
