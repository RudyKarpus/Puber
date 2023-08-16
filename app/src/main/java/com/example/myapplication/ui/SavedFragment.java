package com.example.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.example.myapplication.Interface.SelectListener;
import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.PubData;
import com.example.myapplication.test_data.TestData;
import com.example.myapplication.util.ListPubAdapter;

import java.util.ArrayList;

public class SavedFragment extends Fragment implements SelectListener {
    public SavedFragment(){super(R.layout.saved);}

    private ListPubAdapter adapter;
    private ArrayList<PubData> list=new ArrayList<>();
    private String saved;
    private  RecyclerView save;
    private int l;


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        list.clear();
        save=(RecyclerView) requireView().findViewById(R.id.savelist);
        setup();

    }
    @Override
    public void OnResume()
    {
        super.onResume();
        list.clear();
        setup();


    }

    private void setup()
    {
        saved=AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue();
        l=0;
        Log.d("tak",saved);
        if(saved!=null)
        {
            while(l<saved.length()-1)
            {


                list.add(TestData.getPubDataList().get(Integer.parseInt(saved.substring(l,l+1))-1));
                l++;
            }

            adapter = new ListPubAdapter(list, this);
            save.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClicked(int position) {
        Navigation.findNavController(requireView()).navigate(SearcherFragmentDirections.searcherToDetail());
        AppContainer.getInstance().getPubSearchingContainer().getPosition().setValue(position);
    }



}