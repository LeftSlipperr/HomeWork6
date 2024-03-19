package com.example.homework6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    //Пустой конструктов
    public DetailsFragment() {

    }

    //Инициализация при создании
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    //инициализация при отрисовке
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView countryText = view.findViewById(R.id.textCountry);
        TextView capitalText = view.findViewById(R.id.textCapital);
        TextView squareText = view.findViewById(R.id.squareText);
        ImageView flag = view.findViewById(R.id.imageView);

        Bundle args = getArguments();
        if (args != null) {
            String countryName = args.getString("countryName");
            String capitalName = args.getString("capitalName");
            int square = args.getInt("square");
            int flagId = args.getInt("flagId");

            countryText.setText(countryName);
            capitalText.setText("Столица: " + capitalName);
            squareText.setText("Площадь: " + square);
            flag.setImageResource(flagId);
        }

        return view;
    }


    //Создаю инстанс для того чтобы положить данные
    public static DetailsFragment newInstance(String countryName, String capitalName, int square, int flagId) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString("countryName", countryName);
        args.putString("capitalName", capitalName);
        args.putInt("square", square);
        args.putInt("flagId", flagId);
        fragment.setArguments(args); // Установка аргументов в фрагмент
        return fragment;
    }


    //метод для отображения подробностей о стране
    private void displayCountryDetails(View view, Country country) {
        TextView countryText = view.findViewById(R.id.textCountry);
        countryText.setText(country.getName());

        ImageView flag = view.findViewById(R.id.imageView);
        flag.setImageResource(country.getFlagId());

        TextView capitalText = view.findViewById(R.id.textCapital);
        capitalText.setText("Столица: " + country.getCapital());

        TextView squareText = view.findViewById(R.id.squareText);
        squareText.setText("Площадь: " + country.getSquare());
    }
}