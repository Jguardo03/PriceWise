package com.example.pricewisev2.Recycleview;

public class ProductRVModel {

    private String discount;
    private String productName;
    private String productPrice;
    private String productImageUrl;
    private String merchantImageUrl;


    public ProductRVModel(String discount, String productName, String productPrice, String productImageUrl, String merchantImageUrl) {
        this.discount = discount;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
        this.merchantImageUrl = merchantImageUrl;
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

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getMerchantImageUrl() {
        return merchantImageUrl;
    }

    public void setMerchantImageUrl(String merchantImageUrl) {
        this.merchantImageUrl = merchantImageUrl;
    }


}
