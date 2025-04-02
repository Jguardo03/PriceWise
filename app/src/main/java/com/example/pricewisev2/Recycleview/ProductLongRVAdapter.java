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

public class ProductLongRVAdapter extends RecyclerView.Adapter<ProductLongRVAdapter.ViewHolder> {

    private ArrayList<ProductLongRVModel> productLongRVModelArrayList;

    private Context context;

    public ProductLongRVAdapter(ArrayList<ProductLongRVModel> productLongRVModelArrayList, Context context) {
        this.productLongRVModelArrayList = productLongRVModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_long_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productIV.setImageResource(productLongRVModelArrayList.get(position).getProductImage());
        holder.productNameTV.setText(productLongRVModelArrayList.get(position).getProductName());
        holder.aldiPriceTV.setText(productLongRVModelArrayList.get(position).getAldiPrice());
        holder.aldiIV.setImageResource(productLongRVModelArrayList.get(position).getAldi());
        holder.wolliesPriceTV.setText(productLongRVModelArrayList.get(position).getWollisPrice());
        holder.wolliesIV.setImageResource(productLongRVModelArrayList.get(position).getWollies());
        holder.colesPriceTV.setText(productLongRVModelArrayList.get(position).getColesPrice());
        holder.colesIV.setImageResource(productLongRVModelArrayList.get(position).getColes());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(productLongRVModelArrayList.get(position).getNavRoot());
            }
        });
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
