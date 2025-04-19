package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pricewisev2.R;

import java.util.ArrayList;

public class ProductFragmentRVAdapter extends RecyclerView.Adapter<ProductFragmentRVAdapter.ViewHolder> {

    private ArrayList<ProductFragmentRVModel> productFragmentRVModelArrayList;
    private Context context;

    public ProductFragmentRVAdapter(ArrayList<ProductFragmentRVModel> productFragmentRVModelArrayList, Context context) {
        this.productFragmentRVModelArrayList = productFragmentRVModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductFragmentRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_rv_fragment,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFragmentRVAdapter.ViewHolder holder, int position) {
        holder.productNameTV.setText(productFragmentRVModelArrayList.get(position).getProductName());
        holder.aldiTV.setText(productFragmentRVModelArrayList.get(position).getAldiPrice());
        holder.colesTV.setText(productFragmentRVModelArrayList.get(position).getColesPrice());
        holder.wollisTV.setText(productFragmentRVModelArrayList.get(position).getWollisPrice());
        holder.productDescriptionTV.setText(productFragmentRVModelArrayList.get(position).getProductDescription());

        Glide.with(context)
                .load(productFragmentRVModelArrayList.get(position).getProductImage())
                .placeholder(R.drawable.shopping_cart)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.productImageIV);
        Glide.with(context)
                .load(productFragmentRVModelArrayList.get(position).getAldiImage())
                .placeholder(R.drawable.aldi)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.aldiIV);
        Glide.with(context)
                .load(productFragmentRVModelArrayList.get(position).getColesImage())
                .placeholder(R.drawable.coles)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.colesIV);
        Glide.with(context)
                .load(productFragmentRVModelArrayList.get(position).getWollisImage())
                .placeholder(R.drawable.wollis)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.wollisIV);


    }

    @Override
    public int getItemCount() {
        return productFragmentRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView productNameTV, aldiTV, colesTV, wollisTV, productDescriptionTV;
        private ImageView productImageIV, aldiIV, colesIV, wollisIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTV = itemView.findViewById(R.id.idTVProductNameC);
            productImageIV = itemView.findViewById(R.id.idIVProductC);
            aldiIV = itemView.findViewById(R.id.idIVAldiC);
            colesIV = itemView.findViewById(R.id.idIVColesC);
            wollisIV = itemView.findViewById(R.id.idIVWollisC);
            aldiTV = itemView.findViewById(R.id.idTVAldiPriceC);
            colesTV = itemView.findViewById(R.id.idTVColesPriceC);
            wollisTV = itemView.findViewById(R.id.idTVWollisPriceC);
            productDescriptionTV = itemView.findViewById(R.id.idTVProductDescriptionC2);
        }
    }
}
