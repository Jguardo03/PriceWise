package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pricewisev2.R;
import com.example.pricewisev2.data.shoppinglist.ShoppingListEntity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListRVAdapter extends RecyclerView.Adapter<ShoppingListRVAdapter.ViewHolder>{
    private ArrayList<ShoppingLIstRVModel> shoppingLIstRVModelArrayList;

    private Context context;

    public ShoppingListRVAdapter(ArrayList<ShoppingLIstRVModel> shoppingLIstRVModelArrayList, Context context) {
        this.shoppingLIstRVModelArrayList = shoppingLIstRVModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShoppingListRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shopping_list_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListRVAdapter.ViewHolder holder, int position) {
        holder.listNameTV.setText(shoppingLIstRVModelArrayList.get(position).getListName());
    }

    @Override
    public int getItemCount() {
        return shoppingLIstRVModelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView listNameTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listNameTV = itemView.findViewById(R.id.idShoppingListName);
        }

    }

}
