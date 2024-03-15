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
        DetailsViewModel detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
        // Получение данных о выбранной стране из DetailsViewModel
        detailsViewModel.getSelectedCountry().observe(getViewLifecycleOwner(), new Observer<Country>() {

            //Подробные данные о стране
            @Override
            public void onChanged(Country country) {
                if (country != null) {
                    displayCountryDetails(view, country);
                }
            }
        });

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
        fragment.setArguments(args);
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