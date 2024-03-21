package com.example.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<Country> countries = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries.add(new Country("Moldova", "https://flagsapi.com/MD/flat/64.png", 250, "Chisinau"));
        countries.add(new Country("Australia", "https://flagsapi.com/AU/flat/64.png", 1500, "Canberra"));
        countries.add(new Country("China", "https://flagsapi.com/CN/flat/64.png", 1300, "Beijing"));
        countries.add(new Country("France", "https://flagsapi.com/FR/flat/64.png", 800, "Paris"));
        countries.add(new Country("Germany", "https://flagsapi.com/DE/flat/64.png", 700, "Berlin"));
        countries.add(new Country("Hungary", "https://flagsapi.com/HU/flat/64.png", 300, "Budapest"));
        countries.add(new Country("India", "https://flagsapi.com/IN/flat/64.png", 1000, "New Delhi"));
        countries.add(new Country("Japan", "https://flagsapi.com/JP/flat/64.png", 350, "Tokyo"));
        countries.add(new Country("New-Zealand", "https://flagsapi.com/NZ/flat/64.png", 650, "Wellington"));
        countries.add(new Country("Portugal", "https://flagsapi.com/PT/flat/64.png", 200, "Lisbon"));
        CustomAdapter adapter = new CustomAdapter(this, countries);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = countries.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("flagUrl", selectedCountry.getFlagUrl());
                intent.putExtra("countryName", selectedCountry.getName());
                intent.putExtra("capitalName", selectedCountry.getCapital());
                intent.putExtra("square", selectedCountry.getSquare());
                startActivity(intent);
            }
        });

    }

}