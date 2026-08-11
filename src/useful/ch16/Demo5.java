package useful.ch16;

public class Demo5 {

    public static void main(String[] args) {
       // 배웠던 익명 내부 클래스와 동작이 완전히 같다.

        // 익명 클래스 방식 사용
        MathOperation add1 = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return x + y;
            }
        };


        // 람다식 방식 (완전히 같은 동작)
        MathOperation add2 = (int x, int y) -> x + y;

        System.out.println("익명 클래스: " + add1.operation(100,100));
        System.out.println("람다 표현식: " + add2.operation(100,100));
    }
}
