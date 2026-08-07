package exercise.Cafe;

public class CafeMain {
    public static void main(String[] args) {

        Beverage beverage1 = new Americano();
        Beverage beverage2 = new Latte();

        int totalPrice = 0;

        beverage1.prepare();
        beverage1.serve();
        System.out.println("-----------------");
        beverage2.prepare();
        beverage2.serve();
        System.out.println("-----------------");

        System.out.println("주문: 아메리카노, 라떼");
        totalPrice += beverage1.getPrice();
        totalPrice += beverage2.getPrice();
        System.out.println("총 금액: " + totalPrice + "원");

    }


}
