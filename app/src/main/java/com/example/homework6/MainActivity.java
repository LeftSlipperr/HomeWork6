package com.example.homework6;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
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
        countries.add(new Country("Америка", R.drawable.america));

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