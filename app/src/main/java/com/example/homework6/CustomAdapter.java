package com.example.homework6;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homework6.R;

import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends ArrayAdapter<Country> {

    public CustomAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        ImageView imageView = convertView.findViewById(R.id.flagUrl);

        textView.setText(country.getName());

        Glide.with(getContext())
                .load(country.getFlagUrl())
                .into(imageView);

        return convertView;
    }
}