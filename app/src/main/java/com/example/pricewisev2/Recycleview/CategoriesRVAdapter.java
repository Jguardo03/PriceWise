package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pricewisev2.R;

import java.util.ArrayList;

public class CategoriesRVAdapter extends RecyclerView.Adapter<CategoriesRVAdapter.ViewHolder>{

    private ArrayList<CategoriesRVModel> categoriesRVModelArrayList;

    private Context context;

    public CategoriesRVAdapter(ArrayList<CategoriesRVModel> categoriesRVModelArrayList, Context context) {
        this.categoriesRVModelArrayList = categoriesRVModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriesRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesRVAdapter.ViewHolder holder, int position) {
       holder.categoryIV.setImageResource(categoriesRVModelArrayList.get(position).getCategoryImage());
       holder.cNameTV.setText(categoriesRVModelArrayList.get(position).getCategoryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(categoriesRVModelArrayList.get(position).getNavRoot());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryIV;
        private TextView cNameTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIV = itemView.findViewById(R.id.idIVCategory);
            cNameTV = itemView.findViewById(R.id.idTVCategoryName);
        }
    }
}
