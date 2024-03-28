package com.example.homework6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Country> {
    private Context mContext;
    private List<Country> countries; // Полный список стран
    private List<Country> countriesFull; // Копия полного списка стран
    public CustomAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
        mContext = context;
        this.countriesFull = new ArrayList<>(countries);
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Country> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(countriesFull); // Если строка поиска пустая, отображаем полный список стран
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (Country country : countriesFull) {
                        if (country.getName().toLowerCase().contains(filterPattern)) {
                            filteredList.add(country); // Добавляем страну в отфильтрованный список, если её название содержит текст поиска
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear(); // Очищаем текущий список стран
                addAll((List) results.values); // Добавляем отфильтрованные страны в список
                notifyDataSetChanged(); // Обновляем отображение списка
            }
        };
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
