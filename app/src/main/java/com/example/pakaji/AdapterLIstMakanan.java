package com.example.pakaji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdapterLIstMakanan extends RecyclerView.Adapter<AdapterLIstMakanan.ViewHolder> {
    List<ModelMakananFavorit> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AdapterLIstMakanan(List<ModelMakananFavorit> listData, Context context){
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterLIstMakanan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyleview_row, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLIstMakanan.ViewHolder holder, int position) {
        ModelMakananFavorit makanan = listData.get(position);
        holder.tvMakananFavorite.setText(makanan.getNamaMakanan());
        holder.tvDescription.setText(makanan.getDescription());
        holder.ivMakananFav.setImageResource(makanan.getImageFood());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;
        TextView tvMakananFavorite;
        TextView tvDescription;
        ImageView ivMakananFav;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMakananFavorite = itemView.findViewById(R.id.tvMakananFav);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivMakananFav = itemView.findViewById(R.id.ivMakananFav);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    ModelMakananFavorit getItem(int id) {
        return listData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

