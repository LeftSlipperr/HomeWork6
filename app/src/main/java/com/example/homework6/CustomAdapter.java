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
    private Context mContext;

    public CustomAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.textView);
        ImageView ivFlag = convertView.findViewById(R.id.icon);

        // Загрузка изображения с помощью Glide
        Glide.with(mContext)
                .load(country.getFlags().png) // Используйте URL флага из API
                .into(ivFlag);

        // Заполняем данные
        tvName.setText(country.getName());

        return convertView;
    }
}
