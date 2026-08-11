package useful.ch16;

class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }
}
// 원래 방식: 두 수를 더하거나 빼는 기능을 만들려면 클래스를 설계하고, 객체를 만들고,
// 메서드를 호출하는 기본적인 세 단계르 거쳐야 한다.

public class Demo2 {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println("10 + 5 = "+ calculator.add(10,5));
        System.out.println("10 - 5 = "+ calculator.subtract(10,5));
    }
}
