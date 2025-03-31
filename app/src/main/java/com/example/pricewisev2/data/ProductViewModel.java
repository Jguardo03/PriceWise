package com.example.pricewisev2.data;

import androidx.lifecycle.ViewModel;
import android.content.Context;


public class ProductViewModel extends ViewModel {
    private ProductRepository repository;

    public void createAppRepository (Context context){
        repository = new ProductRepository(context);
    }

    public void insert(ProductEntity product){
        repository.insert(product);
    }

    public void remove(ProductEntity product){
        repository.remove(product);
    }

}
