package homeWork6;

import homeWork6.ProductEntities.AllowedProduct;
import homeWork6.ProductEntities.Product;

public class Task2 {
    public static void main(String[] args) {

        Product lentils = new Product(
                "Чечевица", 9, 0.4,
                20, 116
        );

        Product chickpeas = new Product(
                "Нут", 19, 6,
                61, 364
        );

        AllowedProduct allowedProduct = new AllowedProduct(
                50, 20, 200, 900
        );

        allowedProduct.addProduct(lentils);
        allowedProduct.addProduct(chickpeas);

        allowedProduct.getProductList();
    }
}
