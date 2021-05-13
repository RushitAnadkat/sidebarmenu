package com.example.sidebar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyTransactionItemAdapter extends RecyclerView.Adapter<MyTransactionItemAdapter.ViewHolder> {
    private ArrayList<Transaction_Item> transaction_items;

    public MyTransactionItemAdapter(ArrayList<Transaction_Item> transaction_items, AllTransactions allTransactions) {
        this.transaction_items = transaction_items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transactions_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTransactionItemAdapter.ViewHolder holder, int position) {
        holder.iv.setImageResource(transaction_items.get(position).getImage());
        holder.tv1.setText(String.valueOf(transaction_items.get(position).getAmount()));
        holder.tv2.setText(transaction_items.get(position).getDate());
    }

    @Override
    public int getItemCount() {  return transaction_items.size(); }

    public void setTransactionItems(ArrayList<Transaction_Item> transaction_items) {
        this.transaction_items = transaction_items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivCustomSpinnerImage);
            tv1 = itemView.findViewById(R.id.tvCustomSpinnerText);
            tv2 = itemView.findViewById(R.id.tvdate);
        }
    }
}
