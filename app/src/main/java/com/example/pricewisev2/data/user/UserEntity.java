package com.example.pricewisev2.data.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int userID;
    @ColumnInfo
    public String userName;
    @ColumnInfo
    public String userPassword;
    @ColumnInfo
    public String userAddress;
}
