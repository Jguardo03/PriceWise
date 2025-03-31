package com.example.pricewisev2.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductEntity {
   @PrimaryKey(autoGenerate = true)
    public int productID;

   @ColumnInfo
    public String productName;

   @ColumnInfo
    public String price1;
    @ColumnInfo
    public String price2;
    @ColumnInfo
    public String price3;
}
