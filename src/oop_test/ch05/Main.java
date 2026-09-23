package oop_test.ch05;

public class Main {

    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        itemService.obtainItem("칼", "SSS");
        itemService.obtainItem("총", "A");
        itemService.obtainItem("창", "S");

        itemService.printInventory();
    }
}
