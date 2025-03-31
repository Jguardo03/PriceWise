package com.example.pricewisev2;

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
import com.example.pricewisev2.databinding.FragmentDairyAndEggBinding;

import java.util.ArrayList;

public class DairyAndEggFragment extends Fragment {

    private DairyAndEggViewModel mViewModel;

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
        binding = FragmentDairyAndEggBinding.inflate(inflater, container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        HeaderHelper headerHelper = new HeaderHelper(view);
//        headerHelper.setUpBackNavigation();
        pRV = view.findViewById(R.id.idRVProduct);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productLongRVModelArrayList = new ArrayList<>();
        productLongRVAdapter = new ProductLongRVAdapter(productLongRVModelArrayList,getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productLongRVAdapter);
        addDataToList();
        productLongRVAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DairyAndEggViewModel.class);
        // TODO: Use the ViewModel
    }

    private void addDataToList(){
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Milk",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Eggs",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Bread",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Butter",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Cheese",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));
        productLongRVModelArrayList.add(new ProductLongRVModel(R.drawable.shopping_cart,"Yogurt",R.drawable.coles,"$10.00", R.drawable.wollis,"$8.00",R.drawable.aldi,"$12.00"));

    }
}