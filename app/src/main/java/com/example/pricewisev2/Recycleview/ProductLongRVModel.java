package com.example.pricewisev2.Recycleview;

public class ProductLongRVModel {

    private int productImage;
    private String productName;
    private String aldiPrice;
    private int aldi;
    private String wollisPrice;
    private int wollies;
    private String colesPrice;
    private int coles;
    private int navRoot;

    public ProductLongRVModel(int productImage, String productName, int coles, String colesPrice, int wollies, String wollisPrice, int aldi, String aldiPrice,int navRoot) {
        this.productImage = productImage;
        this.coles = coles;
        this.colesPrice = colesPrice;
        this.wollies = wollies;
        this.wollisPrice = wollisPrice;
        this.aldi = aldi;
        this.aldiPrice = aldiPrice;
        this.productName = productName;
        this.navRoot = navRoot;
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

    public int getNavRoot() {
        return navRoot;
    }

    public void setNavRoot(int navRoot) {
        this.navRoot = navRoot;
    }
}
