package music.data;

import java.util.ArrayList;
import java.util.List;

import music.models.Product;

public class ProductIO {

    public static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("8601",
                "86 (the band) - True Life Songs and Pictures", 14.95));
        products.add(new Product("pf01",
                "Paddlefoot - The first CD", 12.95));
        products.add(new Product("pf02",
                "Paddlefoot - The second CD", 14.95));
        products.add(new Product("jr01",
                "Joe Rut - Genuine Wood Grained Finish", 14.95));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProduct(String productCode) {
        return null;
    }

    public static void insertProduct(Product product) {
    }

    public static void updateProduct(Product product) {
    }

    public static void deleteProduct(String code) {
    }
}
