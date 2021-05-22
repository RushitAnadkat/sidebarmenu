package com.example.sidebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AddiconAdapter extends ArrayAdapter<AddCategoryicon> {
    public AddiconAdapter(@NonNull Context context, ArrayList<AddCategoryicon> addCategoryicons) {
        super(context, 0, addCategoryicons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }
    public View customView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_expense, parent, false);
        }
        AddCategoryicon items = getItem(position);
        ImageView spinnerImage = convertView.findViewById(R.id.ivCustomSpinnerImage);
        if (items != null) {
            spinnerImage.setImageResource(items.getSpinner_icon());
        }
        return convertView;
    }
}
