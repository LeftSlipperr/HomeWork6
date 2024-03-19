package com.example.homework6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConrtyFragment extends Fragment {

    public ConrtyFragment() {
        // Пустой конструктор требуется
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conrty, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        CountriesViewModel viewModel = new ViewModelProvider(requireActivity()).get(CountriesViewModel.class);
        viewModel.getCountries().observe(getViewLifecycleOwner(), countries -> {
            CustomAdapter adapter = new CustomAdapter(getActivity(), countries);
            adapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Country country) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    DetailsFragment detailsFragment = DetailsFragment.newInstance(country.getName(), country.getCapital(), country.getSquare(), country.getFlagId());
                    fragmentTransaction.replace(R.id.fragment_container, detailsFragment);
                    fragmentTransaction.addToBackStack(null); // Добавляем транзакцию в стек возврата
                    fragmentTransaction.commit();
                }
            });
            recyclerView.setAdapter(adapter);
        });

        return view;
    }
}
