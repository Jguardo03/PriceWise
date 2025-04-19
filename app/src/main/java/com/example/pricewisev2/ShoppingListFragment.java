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
import com.example.pricewisev2.Recycleview.ShoppingLIstRVModel;
import com.example.pricewisev2.Recycleview.ShoppingListRVAdapter;
import com.example.pricewisev2.data.user.UserEntity;
import com.example.pricewisev2.data.user.UserViewModel;
import com.example.pricewisev2.data.user.UserViewModelFactory;
import com.example.pricewisev2.databinding.FragmentShoppingListBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListFragment extends Fragment {

    private ShoppingListViewModel mViewModel;
    private UserViewModel userViewModel;
    private RecyclerView pRV;
    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;
    private ProductLongRVAdapter productLongRVAdapter;
    private FragmentShoppingListBinding binding;

    public static ShoppingListFragment newInstance() {
        return new ShoppingListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getActivity() != null){
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Initialize UserViewModel and set up header
        userViewModel = new ViewModelProvider(requireActivity(),
                new UserViewModelFactory(requireActivity().getApplication()))
                .get(UserViewModel.class);
        HeaderHelper headerHelper = new HeaderHelper(view);
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

        pRV = view.findViewById(R.id.idRVShoppingList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        productLongRVModelArrayList = new ArrayList<>();
        productLongRVAdapter = new ProductLongRVAdapter(productLongRVModelArrayList,getActivity());
        pRV.setLayoutManager(linearLayoutManager);
        pRV.setAdapter(productLongRVAdapter);
        productLongRVAdapter.setListener(productId -> {
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
        db.collection("List").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShoppingListViewModel.class);
        // TODO: Use the ViewModel
    }

}