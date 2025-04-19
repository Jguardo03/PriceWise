package com.example.pricewisev2.Recycleview;

public class ProductLongRVModel {

    private String productImage;
    private String productName;
    private String aldiPrice;
    private String aldi;
    private String wollisPrice;
    private String wollies;
    private String colesPrice;
    private String coles;
    private int navRoot;
    private String productID;

    public ProductLongRVModel(String productImage, String productName, String coles, String colesPrice, String wollies,
                              String wollisPrice, String aldi, String aldiPrice,int navRoot,String productID) {
        this.productImage = productImage;
        this.coles = coles;
        this.colesPrice = colesPrice;
        this.wollies = wollies;
        this.wollisPrice = wollisPrice;
        this.aldi = aldi;
        this.aldiPrice = aldiPrice;
        this.productName = productName;
        this.navRoot = navRoot;
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
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

    public String getAldiPrice() {
        return aldiPrice;
    }

    public void setAldiPrice(String aldiPrice) {
        this.aldiPrice = aldiPrice;
    }

    public String getAldi() {
        return aldi;
    }

    public void setAldi(String aldi) {
        this.aldi = aldi;
    }

    public String getWollisPrice() {
        return wollisPrice;
    }

    public void setWollisPrice(String wollisPrice) {
        this.wollisPrice = wollisPrice;
    }

    public String getWollies() {
        return wollies;
    }

    public void setWollies(String wollies) {
        this.wollies = wollies;
    }

    public String getColesPrice() {
        return colesPrice;
    }

    public void setColesPrice(String colesPrice) {
        this.colesPrice = colesPrice;
    }

    public String getColes() {
        return coles;
    }

    public void setColes(String coles) {
        this.coles = coles;
    }

    public int getNavRoot() {
        return navRoot;
    }

    public void setNavRoot(int navRoot) {
        this.navRoot = navRoot;
    }
}
