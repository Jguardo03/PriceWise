package com.example.pricewisev2.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pricewisev2.R;
import com.example.pricewisev2.databinding.FragmentMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private FragmentMainBinding binding;


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity() != null){
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
            bottomNavigationView.setVisibility(View.GONE);
        }

        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.editTextUserName.getText().toString().trim();
                String address = binding.editTextPassword.getText().toString().trim();
                if(!username.isEmpty() && !address.isEmpty()){

                    Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_dashboardFragment);

            }else {
                    Toast.makeText(getActivity(),"Username or Address is empty",Toast.LENGTH_SHORT).show();
                }
        }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(getActivity() != null){
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
    }
}
