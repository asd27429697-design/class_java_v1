package useful.ch16;

// 자바 API에서 제공해주는 함수형 인터페이스 말고
// 내가 직접 설계하고 싶다면 함수형 인터페이스 를 만들어야 한다.

// @FunctionalInterface 은 인터페이스 안에 오직 단 하나의 추상 메서드만 가질 수 있도록 강제한다.
//@FunctionalInterface
//interface MathOperation {
//    int operation(int x, int y);
//    // void run();
//}


public class Demo3 {

    public static void main(String[] args) {

        // 함수형 인터페이스 타입에 람다식을 담을 수 있다.
         MathOperation add = (int x, int y) -> {return x + y; };
         MathOperation subtract = (int x, int y) -> {return x - y; };
         MathOperation multiply = (int x, int y) -> {return x * y; };
         MathOperation divide = (int x, int y) -> {return x / y; };

         // 주의: 호출할 때는 참조 변수의 이름이 아니라 인터페이스에 정의 된
         // 메서드 이름을 호출해야 동작 한다.
        System.out.println("10 + 10 = " + add.operation(10, 10));
        System.out.println("10 - 10 = " + subtract.operation(10, 10));
        System.out.println("10 * 10 = " + multiply.operation(10, 10));
        System.out.println("10 / 10 = " + divide.operation(10, 10));

    }
}
