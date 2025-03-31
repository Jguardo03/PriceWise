package com.example.pricewisev2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> currentAddress;

    public MutableLiveData<String> getCurrentAddress() {
        if (currentAddress == null) {
            currentAddress = new MutableLiveData<String>();
        }
        return currentAddress;
    }
}