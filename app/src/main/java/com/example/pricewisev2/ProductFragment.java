package com.example.pricewisev2;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pricewisev2.Recycleview.ProductFragmentRVAdapter;
import com.example.pricewisev2.Recycleview.ProductFragmentRVModel;
import com.example.pricewisev2.Recycleview.ProductLongRVAdapter;
import com.example.pricewisev2.Recycleview.ProductLongRVModel;
import com.example.pricewisev2.data.user.Product;
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentDairyAndEggBinding;
import com.example.pricewisev2.databinding.FragmentProductBinding;
import com.example.pricewisev2.databinding.ProductRvFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductFragment extends Fragment {

    private ProductViewModel mViewModel;
    private FragmentProductBinding binding;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private UserViewModel userViewModel;
    private RecyclerView pRV;

    private ProductFragmentRVAdapter productFragmentRVAdapter;
    private ArrayList<ProductFragmentRVModel> productFragmentRVModelArrayList;


    public static ProductFragment newInstance() {
        return new ProductFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String productID = getArguments() != null ? getArguments().getString("productId") : null;
        Log.d("bundle", "Id received: " + productID);

        // Header setUp
        if (getActivity() != null) {
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        userViewModel = new ViewModelProvider(requireActivity(), new UserViewModelFactory(requireActivity().getApplication()))
                .get(UserViewModel.class);
        HeaderHelper headerHelper = new HeaderHelper(view);
        headerHelper.setUpBackNavigation();
        userViewModel.getAllUses().observe(getViewLifecycleOwner(), new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                if (userEntities != null && !userEntities.isEmpty()) {
                    for (UserEntity user : userEntities) {
                        String address;
                        address = user.userAddress;
                        headerHelper.setAddress(address);
                    }
                }
            }
        });
        pRV = view.findViewById(R.id.idRVProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productFragmentRVModelArrayList = new ArrayList<>();
        productFragmentRVAdapter = new ProductFragmentRVAdapter(productFragmentRVModelArrayList, getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productFragmentRVAdapter);
        if (productID != null) {
            db.collection("products").document(productID)
                    .get().addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            productFragmentRVModelArrayList.clear();
                            String productName = documentSnapshot.getString("name");
                            String productImage = documentSnapshot.getString("productImage");
                            String colesPrice = String.valueOf(documentSnapshot.getDouble("colesprice"));
                            String wollisPrice = String.valueOf(documentSnapshot.getDouble("wollisprice"));
                            String aldiPrice = String.valueOf(documentSnapshot.getDouble("aldiprice"));
                            String aldiImage = documentSnapshot.getString("aldiImage");
                            String colesImage = documentSnapshot.getString("colesImage");
                            String wollisImage = documentSnapshot.getString("wollisImage");
                            String productDescription = documentSnapshot.getString(("description"));

                            ProductFragmentRVModel product = new ProductFragmentRVModel(
                                    productName,
                                    productImage,
                                    colesImage,
                                    "$" + colesPrice,
                                    wollisImage,
                                    "$" + wollisPrice,
                                    aldiImage,
                                    "$" + aldiPrice, productDescription);
                            productFragmentRVModelArrayList.add(product);
                            productFragmentRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Error loading products", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        binding.buttonAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("List").document(productID).get().addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        Toast.makeText(getActivity(), "Product already on your list", Toast.LENGTH_SHORT).show();
                    } else {
                        db.collection("products").document(productID).get().addOnSuccessListener(documentSnapshot1 -> {
                            if(documentSnapshot1.exists()){
                                Map<String, Object> data = documentSnapshot1.getData();
                            db.collection("List").document(productID).set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getActivity(),"Added to your list",Toast.LENGTH_SHORT).show();
                                }
                            });
                            }else{
                                Toast.makeText(getContext(), "Error loading products", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        binding.buttonRemoveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("List").document(productID).get().addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        db.collection("List").document(productID).delete().addOnSuccessListener(aVoid -> {
                            Toast.makeText(getActivity(), "Product Remove from list", Toast.LENGTH_SHORT).show();
                        });
                    } else {
                        Toast.makeText(getActivity(), "Product not on your list", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

