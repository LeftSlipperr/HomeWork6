package com.example.homework6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

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

        TextView tvName = convertView.findViewById(R.id.textView);
        ImageView ivFlag = convertView.findViewById(R.id.icon);

        tvName.setText(country.getName());
        // Используем Glide для загрузки изображения
        Glide.with(getContext())
                .load(country.getFlagUrl())
                .into(ivFlag);

        return convertView;
    }
}
