package music.models;


import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    public Product() {}

    public Product(String code, String description, double price) {
    }

    public void setCode(String code) {
    }

    public String getCode() {
        return null;
    }

    public void setDescription(String description) {
    }

    public String getDescription() {
        return null;
    }

    public void setPrice(double price) {
    }

    public double getPrice() {
        return 0;
    }

    public String getPriceCurrencyFormat() {
        return null;
    }
}
