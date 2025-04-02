package com.example.pricewisev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;

import com.example.pricewisev2.databinding.ActivityMainBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.Single;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);

    private static final String STRING_KEY_NAME = "string_key";
    private static final Preferences.Key<String> STRING_KEY = PreferencesKeys.stringKey(STRING_KEY_NAME);


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

    }}
