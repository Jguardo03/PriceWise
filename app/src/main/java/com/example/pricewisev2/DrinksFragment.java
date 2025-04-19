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

import com.example.pricewisev2.Recycleview.ProductLongRVAdapter;
import com.example.pricewisev2.Recycleview.ProductLongRVModel;
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentDrinksBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DrinksFragment extends Fragment {

    private DrinksViewModel mViewModel;
    private UserViewModel userViewModel;
    private FragmentDrinksBinding binding;
    private RecyclerView pRV;
    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;
    private ProductLongRVAdapter productLongRVAdapter;

    public static DrinksFragment newInstance() {
        return new DrinksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDrinksBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Header setUp
        if(getActivity() != null){
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
                if(userEntities != null && !userEntities.isEmpty()){
                    for(UserEntity user: userEntities){
                        String address;
                        address = user.userAddress;
                        headerHelper.setAddress(address);
                    }
                }
            }
        });
        headerHelper.setUpBackNavigation();

        pRV = view.findViewById(R.id.idRVProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productLongRVModelArrayList = new ArrayList<>();
        productLongRVAdapter = new ProductLongRVAdapter(productLongRVModelArrayList,getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productLongRVAdapter);
        productLongRVAdapter.setListener(productId -> {
            Log.d("DairyAndEggFragment", "Item clicked, productId: " + productId);
            if (productId != null && !productId.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("productId", productId);
                Log.d("DairyAndEggFragment", "Navigating with bundle: " + bundle.toString());
                Navigation.findNavController(view).navigate(R.id.productFragment, bundle);
            } else {
                Log.e("DairyAndEggFragment", "Invalid productId received in click listener");
                Toast.makeText(getContext(), "Error: Invalid product", Toast.LENGTH_SHORT).show();
            }
        });
        db.collection("products").whereEqualTo("category","Drinks")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            Log.d("Firestore", "Number of documents: " + task.getResult().size());
                            productLongRVModelArrayList.clear();
                            for(QueryDocumentSnapshot document: task.getResult()){
                                String productName = document.getString("name");
                                String productImage = document.getString("productImage");
                                String colesPrice = String.valueOf(document.getDouble("colesprice"));
                                String wollisPrice = String.valueOf(document.getDouble("wollisprice"));
                                String aldiPrice = String.valueOf(document.getDouble("aldiprice"));
                                String aldiImage = document.getString("aldiImage");
                                String colesImage = document.getString("colesImage");
                                String wollisImage = document.getString("wollisImage");
                                String productId = document.getId();

                                ProductLongRVModel product= new ProductLongRVModel(
                                        productImage,
                                        productName,
                                        colesImage,
                                        "$"+colesPrice,
                                        wollisImage,
                                        "$"+wollisPrice,
                                        aldiImage,
                                        "$"+aldiPrice,
                                        R.id.productFragment,productId);
                                productLongRVModelArrayList.add(product);

                            }
                            productLongRVAdapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(getContext(),"Error loading products",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

//    private void addDataToList() {
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Pepsi Multipack",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.pepsiMultipackFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Coca-cola 1.25L",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.cocaCola125Fragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Nescafe Blend Espresso",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.nescafeBlendExpressoFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Coconut Water",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.cocaCola125Fragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Monster Energy Drink",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.monsterEnergyDrinkFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Ice Coffee Boss",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.iceCoffeMrBossFragment));
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DrinksViewModel.class);
    }
}