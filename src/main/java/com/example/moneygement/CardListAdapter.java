package com.example.moneygement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<Money> mMoney;
    public CardListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = layoutInflater.from(mContext).inflate(R.layout.list_tambah_data, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        if(mMoney != null){
            Money money = mMoney.get(position);
            holder.setData(money.getPengeluaran(), money.getKeterangan(), money.getTanggal(), position);
        }else{
            holder.harga.setText("none");
            holder.keterangan.setText("none");
            holder.tanggal.setText("none");
        }
    }

    @Override
    public int getItemCount() {
        if(mMoney != null){
            return mMoney.size();
        }else{
            return 0;
        }
    }

    public void setCard(List<Money> money){
        mMoney = money;
        notifyDataSetChanged();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView harga;
        private AppCompatTextView keterangan;
        private AppCompatTextView tanggal;
        private int mPosition;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            harga = itemView.findViewById(R.id.tvPrice);
            keterangan = itemView.findViewById(R.id.tvNote);
            tanggal = itemView.findViewById(R.id.tvDate);
        }

        public void setData(String pengeluaran, String keterangan, String tanggal, int position){
            harga.setText(pengeluaran);
            this.keterangan.setText(keterangan);
            this.tanggal.setText(tanggal);
            mPosition = position;
        }
    }
}
