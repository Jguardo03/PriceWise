package com.example.pricewisev2.Recycleview;

public class ProductCardModel {
    private int productImage;
    private String productName;
    private String aldiPrice;
    private int aldi;
    private String wollisPrice;
    private int wollies;
    private String colesPrice;
    private int coles;

    private String productDescription;

    public ProductCardModel(int productImage, String productName, String aldiPrice, int aldi, String wollisPrice, int wollies, String colesPrice, int coles, String productDescription) {
        this.productImage = productImage;
        this.productName = productName;
        this.aldiPrice = aldiPrice;
        this.aldi = aldi;
        this.wollisPrice = wollisPrice;
        this.wollies = wollies;
        this.colesPrice = colesPrice;
        this.coles = coles;
        this.productDescription = productDescription;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAldiPrice() {
        return aldiPrice;
    }

    public void setAldiPrice(String aldiPrice) {
        this.aldiPrice = aldiPrice;
    }

    public int getAldi() {
        return aldi;
    }

    public void setAldi(int aldi) {
        this.aldi = aldi;
    }

    public String getWollisPrice() {
        return wollisPrice;
    }

    public void setWollisPrice(String wollisPrice) {
        this.wollisPrice = wollisPrice;
    }

    public int getWollies() {
        return wollies;
    }

    public void setWollies(int wollies) {
        this.wollies = wollies;
    }

    public String getColesPrice() {
        return colesPrice;
    }

    public void setColesPrice(String colesPrice) {
        this.colesPrice = colesPrice;
    }

    public int getColes() {
        return coles;
    }

    public void setColes(int coles) {
        this.coles = coles;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
