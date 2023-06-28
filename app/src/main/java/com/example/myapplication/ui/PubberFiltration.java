package com.example.myapplication.ui;

import static com.example.myapplication.app.Constants.BREWERIES_VIEW_ID_LIST;
import static com.example.myapplication.app.Constants.DRINKS_VIEW_ID_LIST;
import static com.example.myapplication.app.Constants.PRICE_VIEW_ID_LIST;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.FiltrationData;
import com.google.android.material.chip.Chip;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class PubberFiltration extends AppCompatActivity {

    public static final String TAG="PubberFiltration";
    public boolean moreBeers =false;
    private List<String> drinks=new ArrayList<>();;
    private List<String> breweries=new ArrayList<>();
    private boolean open=false;
    private FiltrationData filtrationData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubber_filtration);
    }

    public void filtrationAndGoToPubberSearcher(View view)
    {
        RangeSlider r=findViewById(R.id.rangeRating);
        Slider s=findViewById(R.id.odleglosc);
        /*
        * Filtr sluzacy do testowania
         */
        filtrationData= new FiltrationData.Builder()
                .bottomRating( r.getValues().get(0))
                .upperRating( r.getValues().get(1))
                .isOpen(false)
                .build();
        Log.d(TAG, "filtrationAndGoToPubberSearcher: bottom rating"+r.getValues().get(0)+ ", upper "+r.getValues().get(1));
        AppContainer
                .getInstance()
                .getPubSearchingContainer()
                .getFiltrationOfPubs()
                .setValue(filtrationData);

        //jakiebrowary
        breweriesCheck();
        //drinki
        drinksCheck();
        //cena
        priceCheck();
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


        Intent i=new Intent(this, PubberSearcher.class);
        startActivity(i);
    }

    public void isOpen(View v) {
       open= ((Chip) findViewById(R.id.czyotwarte)).isChecked();
    }

    private void priceCheck(){
        for(var sid:PRICE_VIEW_ID_LIST)
        {
            try {
            int field = R.id.class.getField(sid).getInt(0);
            if(((Chip)findViewById(field)).isChecked()) {
                //filr.add(String.valueOf(((Chip) findViewById(field)).getText()));
            }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                    Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
        }
    }

    private void  drinksCheck(){
        for(var sid:DRINKS_VIEW_ID_LIST)
        {

            try {
                int field = R.id.class.getField(sid).getInt(0);
                if (((Chip) findViewById(field)).isChecked()) {
                    drinks.add(String.valueOf(((Chip) findViewById(field)).getText()));
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
        }
    }


    private void breweriesCheck()  {
        for(var sid:BREWERIES_VIEW_ID_LIST)
        {
            try{
                int field = R.id.class.getField(sid).getInt(0);
                if(((Chip)findViewById(field)).isChecked())
                {
                    breweries.add(String.valueOf(((Chip)findViewById(field)).getText()));
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
                    findViewById(field).setVisibility(View.VISIBLE);
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
                    findViewById(field).setVisibility(View.GONE);
                }
            }catch(NoSuchFieldException | IllegalAccessException e) {
                Log.e(TAG, "drinksCheck: Such View Field doesn't exit");
            }
            moreBeers =false;
        }
    }


}