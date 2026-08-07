package useful.ch05;

public class ThreeDPrinter {

    // 재료
    Plastic material;

    // 재료를 꺼냄
    public Plastic getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Plastic material) {
        this.material = material;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        Plastic plastic = new Plastic();
        ThreeDPrinter threeDPrinter = new ThreeDPrinter();
        threeDPrinter.setMaterial(plastic);

        System.out.println("------------------");
        System.out.println(threeDPrinter.getMaterial());

    }

}
