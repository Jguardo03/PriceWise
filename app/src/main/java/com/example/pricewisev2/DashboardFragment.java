package com.example.pricewisev2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pricewisev2.Recycleview.CategoriesRVAdapter;
import com.example.pricewisev2.Recycleview.CategoriesRVModel;
import com.example.pricewisev2.Recycleview.ProductRVApater;
import com.example.pricewisev2.Recycleview.ProductRVModel;
import com.example.pricewisev2.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;

    private RecyclerView pRV;
    private ArrayList<ProductRVModel> productRVModelArrayList;
    private ProductRVApater productRVApater;
    private RecyclerView cRV;
    private ArrayList<CategoriesRVModel> categoriesRVModelArrayList;

    private CategoriesRVAdapter categoriesRVAdapter;

    private FragmentDashboardBinding binding;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        HeaderHelper headerHelper = new HeaderHelper(view);
//        headerHelper.setAddress();
        headerHelper.setUpBackNavigation();
        pRV = view.findViewById(R.id.idRVDeals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        productRVModelArrayList = new ArrayList<>();
        productRVApater = new ProductRVApater(productRVModelArrayList,getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productRVApater);
        addDataToList();
        productRVApater.notifyDataSetChanged();

        cRV = view.findViewById(R.id.idRVCategories);
        LinearLayoutManager categoryLinearLayoutManager = new GridLayoutManager(getActivity(),  3);
        categoriesRVModelArrayList = new ArrayList<>();
        categoriesRVAdapter = new CategoriesRVAdapter(categoriesRVModelArrayList,getActivity());
        cRV.setLayoutManager(categoryLinearLayoutManager);
        cRV.setAdapter(categoriesRVAdapter);
        addDataToCategoryList();
        categoriesRVAdapter.notifyDataSetChanged();

    }
    private void addDataToList(){
        productRVModelArrayList.add(new ProductRVModel("$5.00","Vegetable Oil", "$10.00",R.drawable.shopping_cart,R.drawable.aldi));
        productRVModelArrayList.add(new ProductRVModel("$2.00","Lentils Can", "$40.00",R.drawable.shopping_cart,R.drawable.wollis));
        productRVModelArrayList.add(new ProductRVModel("$3.00","ALmond Milk", "$8.00",R.drawable.shopping_cart,R.drawable.coles));

    }

    private void addDataToCategoryList(){
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.dalle4,"Dairy and Egg",R.id.dairyAndEggFragment));
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.dalle3,"Fruit and Veggies",R.id.fruitAndVeggiesFragment));
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.dalle2,"Drinks",R.id.drinksFragment));
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.bread,"Bread and Bakery",R.id.bakeryAndBreadFragment));
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.frozen,"Frozen Food",R.id.frozenFoodFragment));
        categoriesRVModelArrayList.add(new CategoriesRVModel(R.drawable.pantry,"Pantry",R.id.action_dashboardFragment_to_dairyAndEggFragment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        // TODO: Use the ViewModel
    }

}
