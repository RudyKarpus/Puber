package com.example.myapplication.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.Interface.SelectListener;
import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.app.NavigationBar;
import com.example.myapplication.data.FiltrationData;
import com.example.myapplication.data.PubData;
import com.example.myapplication.test_data.TestData;
import com.example.myapplication.util.FiltrationUtil;
import com.example.myapplication.util.ListPubAdapter;
import com.google.android.material.chip.Chip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

public class SearcherFragment extends Fragment implements SelectListener {

    public static final String TAG = "SearcherFragment";
    private RecyclerView recyclerView;
    private ListPubAdapter adapter;

    private SearchView searchview;
    private ArrayList<PubData> lista=new ArrayList<>();

    public SearcherFragment() {
        super(R.layout.searcher);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) requireView().findViewById(R.id.Publista);
        TestData.initDataSets();
        adapter = new ListPubAdapter(TestData.getPubDataList(),this);
        recyclerView.setAdapter(adapter);

        final Observer<FiltrationData> nameObserver = filtration -> {
            Log.d(TAG, "onChanged: filtration changed");
            filtrationOfTestDataList(filtration);
        };

        final Observer<List<PubData>> name= sorting->{
            if(AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue()!=null) {


                adapter = new ListPubAdapter(AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().getValue(), this);
                recyclerView.setAdapter(adapter);
            }
        };

        AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().observe(getViewLifecycleOwner(),name);

        AppContainer.getInstance()
                .getPubSearchingContainer()
                .getFiltrationOfPubs()
                .observe(getViewLifecycleOwner(), nameObserver);
        //Refresh publist
        ((SwipeRefreshLayout) requireView().findViewById(R.id.swipeRefresh)).setOnRefreshListener(() -> {

            filtrationOfTestDataList(
                    AppContainer.getInstance()
                    .getPubSearchingContainer()
                    .getFiltrationOfPubs().getValue());
            ((SwipeRefreshLayout) requireView().findViewById(R.id.swipeRefresh)).setRefreshing(false);
        });
        //Setting listener to departure to FiltrationScreen
        ((ImageView) requireView().findViewById(R.id.Filtration)).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(SearcherFragmentDirections.searcherToFiltration());

        });
        ((TextView) requireView().findViewById(R.id.wiecej)).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(SearcherFragmentDirections.searcherToFiltration());

        });
        NavigationBar.smoothPopUp(getActivity().findViewById(R.id.nav_view));
        initSearchView();
       chiplisteners();



    }

    private void chiplisteners()
    {
        ((Chip)requireView().findViewById(R.id.sort)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().setValue(1);
                ((Chip)requireView().findViewById(R.id.sort)).setChecked(true);
            }
        });

        ((Chip)requireView().findViewById(R.id.rating)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().setValue(2);
                ((Chip)requireView().findViewById(R.id.rating)).setChecked(true);

            }
        });
        ((Chip)requireView().findViewById(R.id.distance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().setValue(3);

            }
        });
        ((Chip)requireView().findViewById(R.id.open)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Chip)requireView().findViewById(R.id.open)).isChecked())
                {
                }
                else
                {

                }

            }
        });

    }


    private void filtrationOfTestDataList(FiltrationData filtrationData) {
        ArrayList<PubData> filtrated;
        Log.d(TAG, "filtrationOfTestDataList: filtraion");
        FiltrationUtil filter=new FiltrationUtil(filtrationData, TestData.getPubDataList());
        if (filtrationData == null || filtrationData.equals(new FiltrationData.Builder().build())) {
            filtrated = TestData.getPubDataList();
        } else {
            filtrated=filter
                    .ratingFilter()
                    .distanceFilter()
                    .breweriesFilter()
                    .drinksFilter()
                    .priceFilter()
                    .isOpenFilter()
                    .getPubDataArrayList();
        }
        adapter = new ListPubAdapter(filtrated,this);
        AppContainer.getInstance()
                .getPubSearchingContainer()
                .getListOfFiltratedPubs()
                .setValue(filtrated);
        recyclerView.setAdapter(adapter);

    }
    private void initSearchView()
    {
        searchview=(SearchView)requireView().findViewById(R.id.searchView);
        searchview.setQueryHint("Wyszukaj tutaj");
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                ArrayList<PubData> filtreredpubs=new ArrayList<>();
                for(PubData pub: Objects.requireNonNull(AppContainer.getInstance()
                        .getPubSearchingContainer()
                        .getListOfFiltratedPubs()
                        .getValue()))
                {
                    if(pub.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        filtreredpubs.add(pub);
                    }
                }
                adapter = new ListPubAdapter( filtreredpubs,SearcherFragment.this);
                recyclerView.setAdapter(adapter);

                return false;
            }
        });

    }


    @Override
    public void OnResume() {
        super.onResume();
        if(getActivity().findViewById(R.id.nav_view).getVisibility()==View.GONE)
            NavigationBar.smoothPopUp(getActivity().findViewById(R.id.nav_view));
    }

    @Override
    public void onItemClicked(int position)
    {
        Navigation.findNavController(requireView()).navigate(SearcherFragmentDirections.searcherToDetail());
        AppContainer.getInstance().getPubSearchingContainer().getPosition().setValue(position);

    }





}