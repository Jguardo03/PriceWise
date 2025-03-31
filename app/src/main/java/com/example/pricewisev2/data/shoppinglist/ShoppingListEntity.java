package com.example.pricewisev2.data.shoppinglist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ShoppingListEntity {
    @PrimaryKey(autoGenerate = true)
    public int shoppingListID;
    @ColumnInfo
    public String shoppingListName;
}
