package com.example.homework6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {



    public DetailsFragment() {
        // Required empty public constructor
    }


    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        // Получение данных из Intent
        String countryName = getArguments().getString("countryName");
        String capitalName = getArguments().getString("capitalName");
        int square = getArguments().getInt("square", 0);
        int flagId = getArguments().getInt("flagId", 0);

        // Отображение страны
        TextView countryText = view.findViewById(R.id.textCountry);
        countryText.setText(countryName);
        ImageView flag = view.findViewById(R.id.imageView);
        flag.setImageResource(flagId);
        TextView capitalText = view.findViewById(R.id.textCapital);
        capitalText.setText("Столица: "+ capitalName);
        TextView squareText = view.findViewById(R.id.squareText);
        squareText.setText("Площадь: "+ String.valueOf(square));
        return view;
    }
}