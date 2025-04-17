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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pricewisev2.Recycleview.ProductLongRVAdapter;
import com.example.pricewisev2.Recycleview.ProductLongRVModel;
import com.example.pricewisev2.Recycleview.ProductRVModel;
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentDairyAndEggBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DairyAndEggFragment extends Fragment {

    private DairyAndEggViewModel mViewModel;
    private UserViewModel userViewModel;
    private FragmentDairyAndEggBinding binding;
    private RecyclerView pRV;
    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;
    private ProductLongRVAdapter productLongRVAdapter;

    public static DairyAndEggFragment newInstance() {
        return new DairyAndEggFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDairyAndEggBinding.inflate(inflater, container, false);
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

        pRV = view.findViewById(R.id.idRVProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productLongRVModelArrayList = new ArrayList<>();
        productLongRVAdapter = new ProductLongRVAdapter(productLongRVModelArrayList,getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productLongRVAdapter);
        db.collection("products").whereEqualTo("category","Dairy and Egg")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
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

                                ProductLongRVModel product= new ProductLongRVModel(
                                        productImage,
                                        productName,
                                        colesImage,
                                        "$"+colesPrice,
                                        wollisImage,
                                        "$"+wollisPrice,
                                        aldiImage,
                                        "$"+aldiPrice,R.id.milkFragment);
                                productLongRVModelArrayList.add(product);
                            }
                            productLongRVAdapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(getContext(),"Error loading products",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        binding.idTVCName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.milkFragment);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DairyAndEggViewModel.class);
    }

//    private void addDataToList() {
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Milk",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.milkFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Cheese",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.cheeseFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Butter",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.butterFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Egg",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.eggFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Yogurt",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.yogurtFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Almond Milk",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.almondMilkFragment));
//    }
}