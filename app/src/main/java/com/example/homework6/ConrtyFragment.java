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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConrtyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConrtyFragment extends Fragment {


    List<Country> countries = new ArrayList<>();
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public ConrtyFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ConrtyFragment.
//     */
//    // TODO: Rename and change types and number of parameters
    public static ConrtyFragment newInstance(String param1, String param2) {
        ConrtyFragment fragment = new ConrtyFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
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

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Country selectedCountry = countries.get(position);
//                if (getActivity() != null) {
//                    Intent intent = new Intent(getActivity(), DetailsActivity.class);
//                    intent.putExtra("flagId", selectedCountry.getFlagId());
//                    intent.putExtra("countryName", selectedCountry.getName());
//                    intent.putExtra("capitalName", selectedCountry.getCapital());
//                    intent.putExtra("square", selectedCountry.getSquare());
//                    startActivity(intent);
//                }
//            }
//        });
        return view;
    }
        // Inflate the layout for this fragment

    }
