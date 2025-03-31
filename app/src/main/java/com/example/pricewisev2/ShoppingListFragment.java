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

import com.example.pricewisev2.Recycleview.ShoppingLIstRVModel;
import com.example.pricewisev2.Recycleview.ShoppingListRVAdapter;
import com.example.pricewisev2.databinding.FragmentShoppingListBinding;

import java.util.ArrayList;

public class ShoppingListFragment extends Fragment {

    private ShoppingListViewModel mViewModel;

    private RecyclerView lRV;
    private ArrayList<ShoppingLIstRVModel> shoppingLIstRVModelArrayList;
    private ShoppingListRVAdapter shoppingListRVAdapter;
    private FragmentShoppingListBinding binding;

    public static ShoppingListFragment newInstance() {
        return new ShoppingListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        HeaderHelper headerHelper = new HeaderHelper(view);
//        headerHelper.setUpBackNavigation();
        lRV = view.findViewById(R.id.idRVShoppingList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shoppingLIstRVModelArrayList = new ArrayList<>();
        shoppingListRVAdapter = new ShoppingListRVAdapter(shoppingLIstRVModelArrayList,getActivity());
        lRV.setLayoutManager(linearLayoutManager);
        lRV.setAdapter(shoppingListRVAdapter);
        addDataToList();
        shoppingListRVAdapter.notifyDataSetChanged();
    }

    private void addDataToList() {
        shoppingLIstRVModelArrayList.add(new ShoppingLIstRVModel("Favorites"));
        shoppingLIstRVModelArrayList.add(new ShoppingLIstRVModel("Essentials"));
        shoppingLIstRVModelArrayList.add(new ShoppingLIstRVModel("New"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShoppingListViewModel.class);
        // TODO: Use the ViewModel
    }

}