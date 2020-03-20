package music.models;


import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private double price;
    
    
    public Product() {}

    public Product(String code, String description, double price) {
    	this.code = code;
    	this.description = description;
    	this.price = price;
    }

    public void setCode(String code) {
    	this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setDescription(String description) {
    	this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPrice(double price) {
    	this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getPriceCurrencyFormat() {
        return String.valueOf(this.price);
    }
}
