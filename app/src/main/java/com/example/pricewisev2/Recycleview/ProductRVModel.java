package com.example.pricewisev2.Recycleview;

public class ProductRVModel {

    private String discount;
    private String productName;
    private String productPrice;
    private int productImage;
    private int merchantImage;


    public ProductRVModel(String discount, String productName, String productPrice, int productImage, int merchantImage) {
        this.discount = discount;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.merchantImage = merchantImage;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getMerchantImage() {
        return merchantImage;
    }

    public void setMerchantImage(int merchantImage) {
        this.merchantImage = merchantImage;
    }


}
