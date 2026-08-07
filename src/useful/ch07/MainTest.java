package useful.ch07;

public class MainTest {

    public static void main(String[] args) {

        Water water = new Water();
        Plastic plastic = new Plastic();
        GenericPrinter Printer = new GenericPrinter();
        // Printer.setMaterial(water); // 사실 범위에 제한이 없기 때문에 무엇이든 들어갈 수 있다.

        Printer.setMaterial(plastic);
        System.out.println(Printer.getMaterial());

    } // end of main

} // end of class
