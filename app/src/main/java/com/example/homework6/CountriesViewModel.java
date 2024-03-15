package com.example.homework6;

import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class CountriesViewModel extends ViewModel {

    public MutableLiveData<List<Country>> countries = new MutableLiveData<>();

    public CountriesViewModel(){

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Moldova", R.drawable.moldova, 250, "Chisinau"));
        countryList.add(new Country("Australia", R.drawable.australia, 1500, "Canberra"));
        countryList.add(new Country("China", R.drawable.china, 1300, "Beijing"));
        countryList.add(new Country("France", R.drawable.france, 800, "Paris"));
        countryList.add(new Country("Germany", R.drawable.germany, 700, "Berlin"));
        countryList.add(new Country("Hungary", R.drawable.hungary, 300, "Budapest"));
        countryList.add(new Country("India", R.drawable.india, 1000, "New Delhi"));
        countryList.add(new Country("Japan", R.drawable.japan, 350, "Tokyo"));
        countryList.add(new Country("New-Zealand", R.drawable.new_zealand, 650, "Wellington"));
        countryList.add(new Country("Portugal", R.drawable.portugal, 200, "Lisbon"));

        countries.setValue(countryList);

    }

    public LiveData<List<Country>> getCountries() {
        return countries;
    }

}
