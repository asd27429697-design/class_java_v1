package oop_test.ch03;

public class ProductDao {

    public void insertProduct(Product product) {
        System.out.println("상품명: " + product.getName() + "가격: " + product.getPrice() + "원 상품이 DB에 등록되었습니다.");
    }
}
