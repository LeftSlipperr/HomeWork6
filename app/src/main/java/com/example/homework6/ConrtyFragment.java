package com.example.homework6;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ConrtyFragment extends Fragment {


    List<Country> countries = new ArrayList<>();

    public ConrtyFragment() {
        // Required empty public constructor
    }

    public static ConrtyFragment newInstance(String param1, String param2) {
        ConrtyFragment fragment = new ConrtyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conrty, container, false);
        // Construct the data source
        ArrayList<Country> listCountries = new ArrayList<>();
        listCountries.addAll(countries);
        // Create the adapter to convert the array to views
        CustomAdapter adapter = new CustomAdapter(getActivity(), countries);
        // Attach the adapter to a ListView
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country selectedCountry = countries.get(position);
                if (getActivity() != null) {
                    DetailsFragment detailsFragment = DetailsFragment.newInstance(
                            selectedCountry.getName(),
                            selectedCountry.getCapital(),
                            selectedCountry.getSquare(),
                            selectedCountry.getFlagId()
                    );

                    // Заменяем текущий фрагмент на DetailsFragment
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailsFragment)
                            .addToBackStack(null).commit();
                }
            }
        });
        return view;
    }
}
