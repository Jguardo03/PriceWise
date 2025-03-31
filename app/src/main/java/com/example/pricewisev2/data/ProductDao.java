package com.example.pricewisev2.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ProductDao {

    @Insert
    void insertAll(ProductEntity newProduct);
    @Update
    void modifyProduct(ProductEntity product);
    @Delete
    void removeProduct(ProductEntity product);
    @Query("SELECT * FROM ProductEntity")
    List<ProductEntity> getAll();
}
