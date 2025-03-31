package com.example.pricewisev2.data.shoppinglist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface ShoppingListDao {
    @Insert
    void insertShoppingList(ShoppingListEntity newShoppingList);
    @Delete
    void removeShoppingList(ShoppingListEntity shoppingList);
}
