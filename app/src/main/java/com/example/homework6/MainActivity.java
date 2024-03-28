package com.example.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends Activity {
    private Retrofit retrofit;
    private CountryApi api;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrl = "https://restcountries.com/v3.1/";

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CountryApi.class);

        // Определяем действия при клике на элемент списка
        listView = findViewById(R.id.listView);

        // Получаем список стран с сервера
        Call<List<Country>> call = api.getAllCountry();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Ошибка: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Country> countries = response.body();
                // Создаем адаптер и присваиваем его ListView
                adapter = new CustomAdapter(MainActivity.this, countries);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Определяем действия при клике на элемент списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = adapter.getItem(position);

                // Получаем информацию о выбранной стране по её коду
                Call<Country> call = api.getCountry(selectedCountry.code);
                call.enqueue(new Callback<Country>() {
                    @Override
                    public void onResponse(Call<Country> call, Response<Country> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Ошибка: " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Country detailedCountry = response.body();
                        // Переходим на экран с подробной информацией о стране
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                        intent.putExtra("country", detailedCountry);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Country> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText); // Фильтруем список стран по тексту ввода
                return true;
            }
        });

    }
}
