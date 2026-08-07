package useful.ch09;

/**
 * s내부 클래스란?
 * 한 클래스 내부에 선언된 클래스를 말한다. 내부 클래스를 선언하면
 * 보통 외부 클래스와 연관이 있는 경우에 클래스가 많고 다란 곳에서 거의 사용할 일이 없을 경우
 * 내부에 클래스를 선언하기도 한다.
 * 내부 클래스 종류 4가지 있음.
 * 멤버 내부 클래스
 */

public class OuterClass1 {

    private int num = 10;
    // 1. 멤버 내부 클래스
    class InnerClass {

        public void display() {
            System.out.println("num: " + num);
        }

    } // end of inner class

    public static void main(String[] args) {
        // 내부 클래스가 일반 멤버 클래스로 설게된 경우
        // 외부 클래스가 먼저 객체로 생성이 되고 내부 클래스를 생성할 수 있다.
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();
    }

} // end of outer class
