package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button addButton, getCountryButton;
    EditText countryNameEditText;
    // Адаптер для ListView
    CustomAdapter adapter;

    // Инициализируйте вашу базу данных здесь
    AppDatabase db;
    CountryDao countryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.addButton);
        getCountryButton = findViewById(R.id.getCountryButton);
        countryNameEditText = findViewById(R.id.nameEditText);

        db = App.instance.getDatabase();
        countryDao = db.countryDao();

        updateListView();


        getCountryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Country> users = countryDao.getAll();
                CustomAdapter adapter = new CustomAdapter(getApplicationContext(),users);
                listView.setAdapter(adapter);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = countryNameEditText.getText().toString();
                if (username.length()>0){
                    countryDao.insert(new Country(username, username, 1, username));
                }
            }
        });
    }

    private void updateListView() {
        List<Country> countries = countryDao.getAll();
        adapter = new CustomAdapter(this, countries);
        listView.setAdapter(adapter);
    }
}
