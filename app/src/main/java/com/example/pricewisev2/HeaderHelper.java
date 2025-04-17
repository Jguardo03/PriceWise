package com.example.pricewisev2;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.pricewisev2.databinding.HeaderBinding;

public class HeaderHelper {
    private HeaderBinding binding;
    private NavController navController;


    public HeaderHelper(View view){
        binding = HeaderBinding.bind(view.findViewById(R.id.idIncludeHeader));
        navController = Navigation.findNavController(view);
    }
    public void setAddress (String address){
        binding.textViewAddress.setText(address);
    }
    public void setUpBackNavigation(){
        if (binding != null) {
            binding.imageViewBackArrow.setOnClickListener(v -> navController.navigateUp());
        }
    }
}

