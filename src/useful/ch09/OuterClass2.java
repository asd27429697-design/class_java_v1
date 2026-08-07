package useful.ch09;


public class OuterClass2 {

    private static int num = 10;

    // 2. 정적 내부 클래스
    static class InnerClass {
        public void display() {
            System.out.println("num: " + num);
        }
    }

    public static void main(String[] args) {
        // 1. 멤버 내부 클래스
        // - 외부 클래스와 강하게 연결된 상태
        // - 외부 클래가 생성되어야 내부 클래스를 호출 할 수 있다.

        // 2. 정적 내부 클래스
        // - 외부 클래스와 이름만 묶인 상태
        // ** - 외부 객체 생성없이도 생성이 가능하다. **
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
        innerClass.display();
    }
}
