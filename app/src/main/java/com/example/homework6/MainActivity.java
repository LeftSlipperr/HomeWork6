package com.example.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries.add(new Country("Moldova", R.drawable.moldova, 250, "Chisinau"));
        countries.add(new Country("Australia", R.drawable.australia, 1500, "Canberra"));
        countries.add(new Country("China", R.drawable.china, 1300, "Beijing"));
        countries.add(new Country("France", R.drawable.france, 800, "Paris"));
        countries.add(new Country("Germany", R.drawable.germany, 700, "Berlin"));
        countries.add(new Country("Hungary", R.drawable.hungary, 300, "Budapest"));
        countries.add(new Country("India", R.drawable.india, 1000, "New Delhi"));
        countries.add(new Country("Japan", R.drawable.japan, 350, "Tokyo"));
        countries.add(new Country("New-Zealand", R.drawable.new_zealand, 650, "Wellington"));
        countries.add(new Country("Portugal", R.drawable.portugal, 200, "Lisbon"));

        // Construct the data source
        ArrayList<Country> listCountries = new ArrayList<Country>();
        listCountries.addAll(countries);
        // Create the adapter to convert the array to views
        CustomAdapter adapter = new CustomAdapter(this, countries);
        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = countries.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("flagId", selectedCountry.getFlagId());
                intent.putExtra("countryName", selectedCountry.getName());
                intent.putExtra("capitalName", selectedCountry.getCapital());
                intent.putExtra("square", selectedCountry.getSquare());
                startActivity(intent);
            }
        });

    }

}