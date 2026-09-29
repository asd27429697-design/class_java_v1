package oop_test.ch11;

public class WeekdayPricePolicy implements PricePolicy {
    private int discountAmount = 3000;


    @Override
    public int calculate(int price) {
        return price - discountAmount;
    }
}
