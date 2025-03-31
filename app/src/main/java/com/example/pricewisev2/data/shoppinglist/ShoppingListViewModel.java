package com.example.pricewisev2.data.shoppinglist;

import android.content.Context;

import androidx.lifecycle.ViewModel;

public class ShoppingListViewModel extends ViewModel {
    private ShoppingListRepository repository;

    public void createAppRepository(Context context){
        repository = new ShoppingListRepository(context);
    }

    public void insert(ShoppingListEntity shoppingList){
        repository.insert(shoppingList);
    }
    public void remove(ShoppingListEntity shoppingList){
        repository.remove(shoppingList);
    }
}
