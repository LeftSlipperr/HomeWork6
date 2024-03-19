package com.example.homework6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Country> countries;
    private LayoutInflater inflater;
    public interface OnItemClickListener {
        void onItemClick(Country country);
    }
    private OnItemClickListener listener;


    // Конструктор адаптера
    public CustomAdapter(Context context, List<Country> countries) {
        this.inflater = LayoutInflater.from(context);
        this.countries = countries;
    }

    // Установка слушателя кликов
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvName.setText(country.getName());
        holder.ivFlag.setImageResource(country.getFlagId());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivFlag;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView);
            ivFlag = itemView.findViewById(R.id.icon);
        }
    }
}
