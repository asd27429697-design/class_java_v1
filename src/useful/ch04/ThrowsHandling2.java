package useful.ch04;

public class ThrowsHandling2 {


    public static void main(String[] args) {
      Calc2 calc2 = new Calc2();
      calc2.divide(100,0);
    }

}

class Calc2 {

    public int divide(int n1, int n2) {
        System.out.println("사용자 정의 예외 클래스 사용하는 방법");
        int result = 0;
        try {
            result = n1 / n2;
        } catch (Exception e) {
            throw new DivideByZeroException("0을 어떤 수로 나눌 수 없음");
        }
        return result;
    }
}

