package com.example.pricewisev2.Recycleview;

public class ProductFragmentRVModel {
    private String productName;
    private String productImage;
    private String colesImage;
    private String colesPrice;
    private String wollisImage;
    private String wollisPrice;
    private String aldiImage;
    private String aldiPrice;
    private String productDescription;

    public ProductFragmentRVModel(String productName, String productImage, String colesImage, String colesPrice, String wollisImage, String wollisPrice, String aldiImage, String aldiPrice, String productDescription) {
        this.productName = productName;
        this.productImage = productImage;
        this.colesImage = colesImage;
        this.colesPrice = colesPrice;
        this.wollisImage = wollisImage;
        this.wollisPrice = wollisPrice;
        this.aldiImage = aldiImage;
        this.aldiPrice = aldiPrice;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getColesImage() {
        return colesImage;
    }

    public void setColesImage(String colesImage) {
        this.colesImage = colesImage;
    }

    public String getColesPrice() {
        return colesPrice;
    }

    public void setColesPrice(String colesPrice) {
        this.colesPrice = colesPrice;
    }

    public String getWollisImage() {
        return wollisImage;
    }

    public void setWollisImage(String wollisImage) {
        this.wollisImage = wollisImage;
    }

    public String getWollisPrice() {
        return wollisPrice;
    }

    public void setWollisPrice(String wollisPrice) {
        this.wollisPrice = wollisPrice;
    }

    public String getAldiImage() {
        return aldiImage;
    }

    public void setAldiImage(String aldiImage) {
        this.aldiImage = aldiImage;
    }

    public String getAldiPrice() {
        return aldiPrice;
    }

    public void setAldiPrice(String aldiPrice) {
        this.aldiPrice = aldiPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
