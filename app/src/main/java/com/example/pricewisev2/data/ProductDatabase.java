package com.example.pricewisev2.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

}
