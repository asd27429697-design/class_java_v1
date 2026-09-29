package oop_test.ch09;

public class Order {

    private String menuName;
    private int price;

    public Order(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}
