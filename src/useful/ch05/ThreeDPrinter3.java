package useful.ch05;

import java.util.Objects;

public class ThreeDPrinter3 {

    // 재료
    Object material;

    // 재료를 꺼냄
    public Object getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Object material) {
        this.material = material;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();

        ThreeDPrinter3 printer3 = new ThreeDPrinter3();
        printer3.setMaterial(plastic1);
        System.out.println(printer3.getMaterial());
        System.out.println("-----------------------------");
        printer3.setMaterial(powder1);
        System.out.println(printer3.getMaterial());

        // 타입을 선언해서 저장 시켜 보자.
        Powder tempPowder = (Powder) printer3.getMaterial();
    }

}
