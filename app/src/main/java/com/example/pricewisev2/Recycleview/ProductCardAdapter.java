package com.example.pricewisev2.Recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pricewisev2.R;

import java.text.BreakIterator;
import java.util.ArrayList;


public class ProductCardAdapter extends RecyclerView.Adapter<ProductCardAdapter.ViewHolder> {
    private ArrayList<ProductCardModel> productCardModelArrayList;

    private Context context;

    public ProductCardAdapter(ArrayList<ProductCardModel> productCardModelArrayList, Context context) {
        this.productCardModelArrayList = productCardModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_card_rv_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardAdapter.ViewHolder holder, int position) {
        holder.productIV.setImageResource(productCardModelArrayList.get(position).getProductImage());
        holder.productNameTV.setText(productCardModelArrayList.get(position).getProductName());
        holder.aldiPriceTV.setText(productCardModelArrayList.get(position).getAldiPrice());
        holder.aldiIV.setImageResource(productCardModelArrayList.get(position).getAldi());
        holder.wolliesPriceTV.setText(productCardModelArrayList.get(position).getWollisPrice());
        holder.wolliesIV.setImageResource(productCardModelArrayList.get(position).getWollies());
        holder.colesPriceTV.setText(productCardModelArrayList.get(position).getColesPrice());
        holder.colesIV.setImageResource(productCardModelArrayList.get(position).getColes());
        holder.productDescriptionTV.setText(productCardModelArrayList.get(position).getProductDescription());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView productIV;
        public TextView productNameTV;
        private TextView aldiPriceTV;
        private ImageView aldiIV;
        private ImageView wolliesIV;
        private ImageView colesIV;
        private TextView wolliesPriceTV;
        private TextView colesPriceTV;
        private TextView productDescriptionTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productIV = itemView.findViewById(R.id.idIVProductC);
            productNameTV = itemView.findViewById(R.id.idTVProductNameC);
            aldiPriceTV = itemView.findViewById(R.id.idTVAldiPriceC);
            aldiIV = itemView.findViewById(R.id.idIVAldiC);
            wolliesPriceTV = itemView.findViewById(R.id.idTVWollisPriceC);
            wolliesIV = itemView.findViewById(R.id.idIVWollisC);
            colesPriceTV = itemView.findViewById(R.id.idTVColesPriceC);
            colesIV = itemView.findViewById(R.id.idIVColesC);
            productDescriptionTV = itemView.findViewById(R.id.idTVProductDescriptionC);
        }
    }
}
