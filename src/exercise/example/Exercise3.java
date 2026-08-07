package exercise.example;

public class Exercise3 {

    public static void main(String[] args) {
        // 할인된 가격을 화면에 출력하는 코드 작성
        final double ORIGINAL_PRICE = 59.99;
        final double DISCOUNT_RATE = 0.30; // 30% 할인
        // DISCOUNT_RATE 는 추후 변경될 수 있다 (변경 되더라도 코드를 동작 해야 한다)

        // 할인 계산식을 찾아서 준비

        double discount = (ORIGINAL_PRICE * DISCOUNT_RATE);

        double price = ORIGINAL_PRICE - discount;

        // 할인된 계산 금액을 변수에 담아서 화면에 출력 (단, 정수값으로 출력 하시오)
        System.out.println("할인된 금액: " + (int)price);






    } // end of main

} // end of class
