package com.example.countryname.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryname.R;
import com.example.countryname.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<CountryModel> countriesList;

    public CountryAdapter(ArrayList<CountryModel> countriesList) {
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textView.setText(countriesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }


    // View Holder
    class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.country_textview);

        }

    }

}
