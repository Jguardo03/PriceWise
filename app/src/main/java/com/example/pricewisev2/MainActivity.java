package com.example.pricewisev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.pricewisev2.databinding.ActivityMainBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.dashboardFragment){
                Navigation.findNavController(this,R.id.idNav_host_fragment).navigate(R.id.dashboardFragment);
            } else if (item.getItemId() == R.id.shoppingListFragment) {
                Navigation.findNavController(this,R.id.idNav_host_fragment).navigate(R.id.shoppingListFragment);
            } else if (item.getItemId() == R.id.profileFragment) {
                Navigation.findNavController(this,R.id.idNav_host_fragment).navigate((R.id.profileFragment));
            }

            return false;
        });

    }
}