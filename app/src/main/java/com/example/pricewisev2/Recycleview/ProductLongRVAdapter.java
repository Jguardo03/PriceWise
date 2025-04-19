package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pricewisev2.R;

import java.util.ArrayList;

public class ProductLongRVAdapter extends RecyclerView.Adapter<ProductLongRVAdapter.ViewHolder> {

    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;

    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(String productId);
    }

    public ProductLongRVAdapter(ArrayList<ProductLongRVModel> productLongRVModelArrayList, Context context) {
        this.productLongRVModelArrayList = productLongRVModelArrayList;
        this.context = context;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_long_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductLongRVModel product = productLongRVModelArrayList.get(position);

        //Set on click listener
        holder.itemView.setOnClickListener(v->{
            if(listener!=null){
                String productId = product.getProductID();
                listener.onItemClick(productId);
            }
        });
        // Load product image
        if (product.getProductImage() != null && !product.getProductImage().isEmpty()) {
            Glide.with(context)
                .load(product.getProductImage())
                .placeholder(R.drawable.shopping_cart)
                .error(R.drawable.shopping_cart)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.productIV);
        } else {
            holder.productIV.setImageResource(R.drawable.shopping_cart);
        }

        holder.productNameTV.setText(product.getProductName());
        holder.aldiPriceTV.setText(product.getAldiPrice());

        // Load Aldi logo
        if (product.getAldi() != null && !product.getAldi().isEmpty()) {
            Glide.with(context)
                .load(product.getAldi())
                .placeholder(R.drawable.aldi)
                .error(R.drawable.aldi)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.aldiIV);
        } else {
            holder.aldiIV.setImageResource(R.drawable.aldi);
        }

        holder.wolliesPriceTV.setText(product.getWollisPrice());

        // Load Woolworths logo
        if (product.getWollies() != null && !product.getWollies().isEmpty()) {
            Glide.with(context)
                .load(product.getWollies())
                .placeholder(R.drawable.wollis)
                .error(R.drawable.wollis)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.wolliesIV);
        } else {
            holder.wolliesIV.setImageResource(R.drawable.wollis);
        }

        holder.colesPriceTV.setText(product.getColesPrice());

        // Load Coles logo
        if (product.getColes() != null && !product.getColes().isEmpty()) {
            Glide.with(context)
                .load(product.getColes())
                .placeholder(R.drawable.coles)
                .error(R.drawable.coles)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.colesIV);
        } else {
            holder.colesIV.setImageResource(R.drawable.coles);
        }
    }

    @Override
    public int getItemCount() {
        return productLongRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productIV;
        private TextView productNameTV;
        private TextView aldiPriceTV;
        private ImageView aldiIV;
        private ImageView wolliesIV;
        private ImageView colesIV;
        private TextView wolliesPriceTV;
        private TextView colesPriceTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productIV = itemView.findViewById(R.id.idIVProduct);
            productNameTV = itemView.findViewById(R.id.idTVProductNameL);
            aldiPriceTV = itemView.findViewById(R.id.idTVAldiPrice);
            aldiIV = itemView.findViewById(R.id.idIVAldi);
            wolliesPriceTV = itemView.findViewById(R.id.idTVWollisPrice);
            wolliesIV = itemView.findViewById(R.id.idIVWollis);
            colesPriceTV = itemView.findViewById(R.id.idTVColesPrice);
            colesIV = itemView.findViewById(R.id.idIVColes);
        }
    }
}
