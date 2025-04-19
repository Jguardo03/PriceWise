package com.example.pricewisev2.data.user;

public class Product {
    private String productName;
    private String productDescription;
    private double colesPrice;
    private double wollisPrice;
    private double aldiPrice;
    private String productImage;

    public Product(){}

    public Product(String productName, String productDescription, double colesPrice, double wollisPrice, double aldiPrice,String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.colesPrice = colesPrice;
        this.wollisPrice = wollisPrice;
        this.aldiPrice = aldiPrice;
        this.productImage = productImage;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getColesPrice() {
        return colesPrice;
    }

    public void setColesPrice(double colesPrice) {
        this.colesPrice = colesPrice;
    }

    public double getWollisPrice() {
        return wollisPrice;
    }

    public void setWollisPrice(double wollisPrice) {
        this.wollisPrice = wollisPrice;
    }

    public double getAldiPrice() {
        return aldiPrice;
    }

    public void setAldiPrice(double aldiPrice) {
        this.aldiPrice = aldiPrice;
    }
}
