package com.example.pricewisev2.data.shoppinglist;

import android.content.Context;

import androidx.room.Room;

import com.example.pricewisev2.data.ProductDatabase;

public class ShoppingListRepository {

    private ShoppingListDatabase db;
    private ShoppingListDao shoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = Room.databaseBuilder(context,
                ShoppingListDatabase.class,"database-name").allowMainThreadQueries().build();
        shoppingListDao = db.shoppingListDao();
    }

    public void insert(ShoppingListEntity shoppingList){shoppingListDao.insertShoppingList(shoppingList);}

    public  void remove(ShoppingListEntity shoppingList){shoppingListDao.removeShoppingList(shoppingList);}
}
