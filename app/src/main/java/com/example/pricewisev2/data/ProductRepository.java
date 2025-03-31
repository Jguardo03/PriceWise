package com.example.pricewisev2.data;

import androidx.room.Room;
import android.content.Context;

public class ProductRepository {

    private ProductDatabase db;
    private ProductDao productDao;
    public ProductRepository(Context context){
        ProductDatabase db = Room.databaseBuilder(context,
                ProductDatabase.class, "database-name").allowMainThreadQueries().build();
        productDao = db.productDao();
    }

    public void insert(ProductEntity product){
        productDao.insertAll(product);
    }

    public void remove(ProductEntity product){
        productDao.removeProduct(product);
    }
}
