package exercise.Cafe;

public class Americano extends Beverage{


    public Americano() {
        super("아메리카노", 3000);

    }

    @Override
    public void prepare() {
        System.out.println("에스프레소에 물을 붓습니다");
    }
}
