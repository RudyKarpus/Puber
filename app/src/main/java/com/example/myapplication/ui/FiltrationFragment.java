package com.example.myapplication.ui;

import static com.example.myapplication.app.Constants.BREWERIES_VIEW_ID_LIST;
import static com.example.myapplication.app.Constants.DRINKS_VIEW_ID_LIST;
import static com.example.myapplication.app.Constants.PRICE_VIEW_ID_LIST;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.FiltrationData;
import com.google.android.material.chip.Chip;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class FiltrationFragment extends Fragment {

    public static final String TAG="FiltrationFragment";
    public boolean moreBeers =false;
    private List<String> drinks=new ArrayList<>();;
    private List<String> breweries=new ArrayList<>();
    private boolean open=false;
    private FiltrationData filtrationData;

    public FiltrationFragment()
    {
        super(R.layout.filtration);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

       requireView().findViewById(R.id.buttonfiltr).setOnClickListener(v->{
           filtration(requireView());
           Navigation.findNavController(v).navigate(FiltrationFragmentDirections.filtrationToSearcher());
       });
    }


    public void filtration(View view)
    {
        RangeSlider r=view.findViewById(R.id.rangeRating);
        Slider s=view.findViewById(R.id.odleglosc);
        filtrationData= new FiltrationData.Builder()
                .bottomRating( r.getValues().get(0))
                .upperRating( r.getValues().get(1))
                .isOpen(false)
                .build();
        Log.d(TAG, "filtration: bottom rating"+r.getValues().get(0)+ ", upper "+r.getValues().get(1));
        AppContainer
                .getInstance()
                .getPubSearchingContainer()
                .getFiltrationOfPubs()
                .setValue(filtrationData);

        //jakiebrowary
        breweriesCheck(view);
        //drinki
        drinksCheck(view);
        //cena
        priceCheck(view);
        /*
        * Poprawny filtr
        *    filtrationData=new FiltrationData.Builder()
                .distance(s.getValue())
                .bottomRating( r.getValues().get(0))
                .upperRating( r.getValues().get(1))
                .isOpen(open)
                .breweries(breweries)
                .drinks(drinks)
                .build();
         */
    }


    public void isOpen(View v) {
       open= ((Chip) v.findViewById(R.id.czyotwarte)).isChecked();
    }

    private void priceCheck(View v){
        for(var sid:PRICE_VIEW_ID_LIST)
        {
            try {
            int field = R.id.class.getField(sid).getInt(0);
            if(((Chip) v.findViewById(field)).isChecked()) {
                //filr.add(String.valueOf(((Chip) findViewById(field)).getText()));
            }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                    Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
        }
    }

    private void  drinksCheck(View v){
        for(var sid:DRINKS_VIEW_ID_LIST)
        {

            try {
                int field = R.id.class.getField(sid).getInt(0);
                if (((Chip) v.findViewById(field)).isChecked()) {
                    drinks.add(String.valueOf(((Chip) v.findViewById(field)).getText()));
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
        }
    }


    private void breweriesCheck(View v)  {
        for(var sid:BREWERIES_VIEW_ID_LIST)
        {
            try{
                int field = R.id.class.getField(sid).getInt(0);
                if(((Chip)v.findViewById(field)).isChecked())
                {
                    breweries.add(String.valueOf(((Chip)v.findViewById(field)).getText()));
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
        }
    }
    public void moreBeers(View v)  {
        if (!moreBeers)
        {
            try{
                for(var sid:BREWERIES_VIEW_ID_LIST)
                {
                    int field = R.id.class.getField(sid).getInt(0);
                   v.findViewById(field).setVisibility(View.VISIBLE);
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
            moreBeers =true;
        }
        else
        {
            try {
                for (var sid : BREWERIES_VIEW_ID_LIST) {
                    int field = R.id.class.getField(sid).getInt(0);
                    v.findViewById(field).setVisibility(View.GONE);
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
            moreBeers =false;
        }
    }


}