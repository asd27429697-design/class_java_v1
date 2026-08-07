package useful.ch05;

public class ThreeDPrinter2 {

    // 재료
    Powder material;

    // 재료를 꺼냄
    public Powder getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Powder material) {
        this.material = material;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        Powder powder1 = new Powder();
        ThreeDPrinter2 threeDPrinter = new ThreeDPrinter2();
        threeDPrinter.setMaterial(powder1);

        System.out.println("------------------");
        System.out.println(threeDPrinter.getMaterial());

    }

}
