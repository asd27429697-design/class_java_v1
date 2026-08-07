package exercise.Cafe;

public  class Latte extends Beverage{

    public Latte() {
        super("라떼", 4500);
    }

    @Override
    public void prepare() {
        System.out.println("에스프레소에 우유를 붓습니다");
    }
}

