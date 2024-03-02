package com.example.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
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

        countries.add(new Country("Молдова", R.drawable.moldova));
        countries.add(new Country("Австралия", R.drawable.australia));
        countries.add(new Country("Китай", R.drawable.china));
        countries.add(new Country("Франция", R.drawable.france));
        countries.add(new Country("Германия", R.drawable.germany));
        countries.add(new Country("Венгрия", R.drawable.hungary));
        countries.add(new Country("Индия", R.drawable.india));
        countries.add(new Country("Япония", R.drawable.japan));
        countries.add(new Country("Новая Зеландия", R.drawable.new_zealand));
        countries.add(new Country("Португалия", R.drawable.portugal));

        // Construct the data source
        ArrayList<Country> listCountries = new ArrayList<Country>();
        listCountries.addAll(countries);
        // Create the adapter to convert the array to views
        CustomAdapter adapter = new CustomAdapter(this, countries);
        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

}