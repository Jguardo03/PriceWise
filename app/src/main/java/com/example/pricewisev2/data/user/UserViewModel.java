package com.example.pricewisev2.data.user;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<UserEntity>> allUses;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application.getApplicationContext());
        allUses = userRepository.getAllUsers();
    }

    public LiveData<List<UserEntity>> getAllUses(){return allUses;}
    public void insert(UserEntity user){
        userRepository.insert(user);
    }
    public void delete(UserEntity user){
        userRepository.delete(user);
    }
    public void modify(UserEntity user){
        userRepository.modify(user);
    }
}
