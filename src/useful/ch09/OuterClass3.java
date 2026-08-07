package useful.ch09;

// 3. 지역 내부 클래스 <- 거의 안씀
public class OuterClass3 {

    public void display() {

        // 메서드 안에 클래스를 선언 할 수 있다.
        class LocalInnerClass {

            void printMessage() {
                System.out.println("지역 내부 클래스 메서드");
            }
        } // end of local class

    }

    public static void main(String[] args) {
        // 지역 내부클래스는 메서드 실행 시에만 존재하고 메서드의 지역 변수처럼 동작한다.
        // 외부에서는 접근할 수 없으며, 주로 메서드 내에서 일회성 작업을 수행한는 객체를
        // 생성할 때 사용할 수 있다.
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.display();
    }

}
