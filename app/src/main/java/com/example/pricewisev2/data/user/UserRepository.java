package com.example.pricewisev2.data.user;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class UserRepository {

    private UserDatabase db;
    private final UserDao userDao;
    private final LiveData<List<UserEntity>> allUsers;

    public UserRepository(Context context){
        this.db = UserDatabase.getDatabase(context);
        userDao = this.db.userDao();
        allUsers = userDao.readAllData();
    }

    public void insert(UserEntity user){
        userDao.insertUser(user);
    }
    public LiveData<List<UserEntity>> getAllUsers(){
        return allUsers;
    }
    public void delete(UserEntity user){
        userDao.deleteUser(user);
    }
    public void modify(UserEntity user){
        userDao.modifyUser(user);
    }

}
