package com.example.pricewisev2.data.shoppinglist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ShoppingListEntity.class},version = 1)
public abstract class ShoppingListDatabase extends RoomDatabase {
    public abstract ShoppingListDao shoppingListDao();
}
