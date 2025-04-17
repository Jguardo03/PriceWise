package com.example.pricewisev2.ui.main;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.lifecycle.Observer;
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
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private UserViewModel userViewModel;
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
                String password = binding.editTextPassword.getText().toString().trim();
                
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Username or Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                userViewModel = new ViewModelProvider(requireActivity(),
                        new UserViewModelFactory(requireActivity().getApplication()))
                        .get(UserViewModel.class);
                
                userViewModel.getAllUses().observe(getViewLifecycleOwner(), new Observer<List<UserEntity>>() {
                    @Override
                    public void onChanged(List<UserEntity> users) {
                        if (users != null && !users.isEmpty()) {
                            boolean isAuthenticated = false;
                            for (UserEntity user : users) {
                                if (user.userName.equals(username) && user.userPassword.equals(password)) {
                                    isAuthenticated = true;
                                    break;
                                }
                            }
                            
                            if (isAuthenticated) {
                                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_dashboardFragment);
                            } else {
                                Toast.makeText(getActivity(), "Username or Password Incorrect", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        binding.idbuttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.registerFragment);
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
