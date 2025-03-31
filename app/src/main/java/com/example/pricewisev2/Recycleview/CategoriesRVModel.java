package com.example.pricewisev2.Recycleview;

public class CategoriesRVModel {


    private int categoryImage;
    private String categoryName;
    private int navRoot;

    public CategoriesRVModel(int categoryImage, String categoryName, int navRoot) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
        this.navRoot = navRoot;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public int getNavRoot() {
        return navRoot;
    }

    public void setNavRoot(int navRoot) {
        this.navRoot = navRoot;
    }

   }
