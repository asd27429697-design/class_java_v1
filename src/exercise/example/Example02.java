package exercise.example;

public class Example02 {
    public static void main(String[] args) {
       final double TOTAL_PRICE = 125.50;
       final double POINT_RATE = 0.05;

       double price = TOTAL_PRICE * POINT_RATE;

        System.out.println("적립된 금액: " + (int)price);

        System.out.println("====================");

        final double TOTAL_BONUS = 250.75;
        final double TAX_RATE = 0.15;

        double rate = TOTAL_BONUS - TAX_RATE;

        System.out.println("내가 받는 금액: " + (int)rate);

        final double FOOD = 28500;
        final double COUPON_RATE = 0.12;

        double rate1 = FOOD * COUPON_RATE;

        double rate2 = FOOD - rate1;

        System.out.println((int)rate2);


        // 배달 할인

        final double CKPRICE = 21000;
        final double RATE3 = 0.30;

        double price1 = CKPRICE * RATE3;

        double finalprice = CKPRICE - price1;

        System.out.println("할인된 치킨가격: " + (int)finalprice);




    }
}
