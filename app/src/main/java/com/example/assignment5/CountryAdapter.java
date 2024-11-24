package com.example.assignment5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<String> countryList;
    private OnItemClickListener onItemClickListener;

    public CountryAdapter(List<String> countryList, OnItemClickListener onItemClickListener) {
        this.countryList = countryList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        String countryName = countryList.get(position);
        holder.countryName.setText(countryName);

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(countryName));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;

        public CountryViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String countryName);
    }
}
