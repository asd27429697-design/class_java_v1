package oop_test.ch03;

public class ProductService {

    ProductDao productDao = new ProductDao();
    public void registerProduct(String name, int price) {
        Product product = new Product(name, price);
        productDao.insertProduct(product);
    }
}
