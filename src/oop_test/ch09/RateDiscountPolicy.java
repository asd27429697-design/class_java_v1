package oop_test.ch09;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
