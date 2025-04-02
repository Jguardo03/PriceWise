package com.example.pricewisev2.data.user;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static volatile UserDatabase INSTANCE;
    public static UserDatabase getDatabase(final Context context){
        if(INSTANCE ==null){
                synchronized (UserDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                        UserDatabase.class, "Database").allowMainThreadQueries()
                                .build();
                    }
                }
        }return INSTANCE;
    }
}
