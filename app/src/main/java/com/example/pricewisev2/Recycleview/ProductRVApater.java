package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pricewisev2.R;

import java.util.ArrayList;

public class ProductRVApater extends RecyclerView.Adapter<ProductRVApater.ViewHolder> {
    private ArrayList<ProductRVModel> productRVModelArrayList;
    private Context context;

    public ProductRVApater(ArrayList<ProductRVModel> productRVModelArrayList, Context context) {
        this.productRVModelArrayList = productRVModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductRVApater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRVApater.ViewHolder holder, int position) {
        ProductRVModel product = productRVModelArrayList.get(position);
        
        holder.pDiscountTV.setText(productRVModelArrayList.get(position).getDiscount());
        holder.pNameTV.setText(productRVModelArrayList.get(position).getProductName());
        holder.pPriceTV.setText(productRVModelArrayList.get(position).getProductPrice());

        // Load product image with Glide
        Glide.with(context)
            .load(productRVModelArrayList.get(position).getProductImageUrl())
            .placeholder(R.drawable.shopping_cart) // Default image while loading
            .error(R.drawable.shopping_cart) // Image to show if loading fails
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.productIV);

        // Load merchant image with Glide
        Glide.with(context)
            .load(productRVModelArrayList.get(position).getMerchantImageUrl())
            .placeholder(R.drawable.coles) // Default merchant image while loading
            .error(R.drawable.coles) // Image to show if loading fails
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.merchantIV);
    }

    @Override
    public int getItemCount() {
        return productRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pNameTV, pDiscountTV, pPriceTV;
        private ImageView productIV, merchantIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pNameTV = itemView.findViewById(R.id.idTVProductName);
            productIV = itemView.findViewById(R.id.idIVProduct);
            pDiscountTV = itemView.findViewById(R.id.idTVProductDiscount);
            pPriceTV = itemView.findViewById(R.id.idTVProductPrice);
            merchantIV = itemView.findViewById(R.id.idIVMerchant);
        }
    }
}


