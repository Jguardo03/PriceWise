package com.example.pricewisev2;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pricewisev2.Recycleview.ProductLongRVAdapter;
import com.example.pricewisev2.Recycleview.ProductLongRVModel;
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentFrozenFoodBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FrozenFoodFragment extends Fragment {

    private FrozenFoodViewModel mViewModel;
    private UserViewModel userViewModel;
    private FragmentFrozenFoodBinding binding;
    private RecyclerView pRV;
    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;
    private ProductLongRVAdapter productLongRVAdapter;

    public static FrozenFoodFragment newInstance() {
        return new FrozenFoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFrozenFoodBinding.inflate(inflater, container, false);
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
        //addDataToList();
        productLongRVAdapter.notifyDataSetChanged();
    }

//    private void addDataToList() {
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Drumstick Ice Cream",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.drumbStickIceCreamFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Vanilla Ice Cream 1L",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.vanillaIceCream1LFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Sausage Rolls 4 pck",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.sausageRollsFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Frozen Peas",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.frozenPeasFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Hash Browns",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.hashbrownsFragment));
//        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Frozen Fries",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00",R.id.frozenFriesFragment));
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FrozenFoodViewModel.class);
    }
}