package com.example.pricewisev2;

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

import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class RegisterFragment extends Fragment {

    private UserViewModel userViewModel;
    private FragmentRegisterBinding binding;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
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
        // Initialize the UserViewModel
        userViewModel = new ViewModelProvider(requireActivity(),
                new UserViewModelFactory(requireActivity().getApplication()))
                .get(UserViewModel.class);

        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.ideditTextPasword.getText().toString().trim();
                String conPassword = binding.ideditTextConfirmPassword.getText().toString().trim();
                String userName = binding.ideditTextUserName.getText().toString().trim();
                String address = binding.ideditTextAddress.getText().toString().trim();

                if (password.isEmpty() || conPassword.isEmpty() || userName.isEmpty() || address.isEmpty()) {
                    Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(conPassword)) {
                    Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                // Check for existing username in Firestore
                db.collection("users")
                        .whereEqualTo("userName", userName)
                        .get()
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                QuerySnapshot querySnapshot = task.getResult();
                                if (querySnapshot != null && !querySnapshot.isEmpty()) {
                                    // Username already exists
                                    Toast.makeText(getActivity(), "Username already exists", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Username doesn't exist, proceed with registration
                                    UserEntity newUser = new UserEntity();
                                    newUser.userName = userName;
                                    newUser.userPassword = password;
                                    newUser.userAddress = address;

                                    // Add to Firestore
                                    db.collection("users")
                                            .add(newUser)
                                            .addOnSuccessListener(documentReference -> {
//                                                // Add to local Room database
//                                                userViewModel.insert(newUser);
//                                                Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();
//                                                Navigation.findNavController(view).navigate(R.id.mainFragment);
                                            })
                                            .addOnFailureListener(e -> {
                                                Toast.makeText(getActivity(), "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            });
                                }
                            } else {
                                Toast.makeText(getActivity(), "Error checking username: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
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
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Remove the RegisterViewModel initialization as we're using UserViewModel
    }
}