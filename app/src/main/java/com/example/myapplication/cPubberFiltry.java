package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class cPubberFiltry extends AppCompatActivity {

    public static List<Float> lista=new ArrayList<Float>(2);
    private List<String> filtr;
    public String otwarte;
    public float w;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpubber_filtry);
        otwarte="nie";


    }



    public void Wyjscie()
    {
        filtr = new ArrayList<String>();
        //ocena
        RangeSlider r=findViewById(R.id.ocena);
        lista=r.getValues();
        filtr.add(String.valueOf(lista.get(0)));
        filtr.add(String.valueOf(lista.get(1)));
        //odległość
        Slider s=findViewById(R.id.odleglosc);
        if(s.getValue()==0)
        {
            filtr.add(String.valueOf(0.5));
        }
        else
        {
            filtr.add(String.valueOf(s.getValue()));
        }
        //czyowarte
        filtr.add(otwarte);
        //jakiebrowary
        sprawdzenie();
        filtr.add("style");
        //drinki
        sprawdz();
        //cena
        spraw();


        Intent i=new Intent(this, cPubber.class);
        Intent intent = getIntent();
        intent.putStringArrayListExtra("ocena", (ArrayList<String>) filtr);
        startActivity(i);

    }

    private void spraw()
    {
        if(((Chip)findViewById(R.id.malo)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.malo)).getText()));
        }
        if(((Chip)findViewById(R.id.srednio)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.srednio)).getText()));
        }
        if(((Chip)findViewById(R.id.duzo)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.duzo)).getText()));
        }
    }

    private void sprawdz()
    {
        if(((Chip)findViewById(R.id.BlackRussian)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.BlackRussian)).getText()));
        }
        if(((Chip)findViewById(R.id.B52)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.B52)).getText()));
        }
        if(((Chip)findViewById(R.id.Cosmopolitan)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Cosmopolitan)).getText()));
        }
        if(((Chip)findViewById(R.id.CubaLibre)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.CubaLibre)).getText()));
        }
        if(((Chip)findViewById(R.id.Daiquiri)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Daiquiri)).getText()));
        }
        if(((Chip)findViewById(R.id.Kamikaze)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Kamikaze)).getText()));
        }
        if(((Chip)findViewById(R.id.KrwawaMary)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.KrwawaMary)).getText()));
        }
        if(((Chip)findViewById(R.id.LongIsland)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.LongIsland)).getText()));
        }
        if(((Chip)findViewById(R.id.Margarita)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Margarita)).getText()));
        }
        if(((Chip)findViewById(R.id.Martini)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Martini)).getText()));
        }
        if(((Chip)findViewById(R.id.Mojito)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Mojito)).getText()));
        }
        if(((Chip)findViewById(R.id.PinaColada)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.PinaColada)).getText()));
        }
        if(((Chip)findViewById(R.id.Sexonthebeach)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Sexonthebeach)).getText()));
        }
        if(((Chip)findViewById(R.id.TequilaSunrise)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.TequilaSunrise)).getText()));
        }
    }


    public void otwarte(View v)
    {
        if(otwarte=="nie")
        {
            otwarte="tak";
        }
        else
        {
            otwarte="nie";
        }
    }

    private void sprawdzenie()
    {
        if(((Chip)findViewById(R.id.AleBrowar)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.AleBrowar)).getText()));
        }
        if(((Chip)findViewById(R.id.Amber)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Amber)).getText()));
        }
        if(((Chip)findViewById(R.id.Artezan)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Artezan)).getText()));
        }
        if(((Chip)findViewById(R.id.Brokreacja)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Brokreacja)).getText()));
        }
        if(((Chip)findViewById(R.id.Budweiser)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Budweiser)).getText()));
        }
        if(((Chip)findViewById(R.id.Cieszyn)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Cieszyn)).getText()));
        }
        if(((Chip)findViewById(R.id.Fortuna)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Fortuna)).getText()));
        }
        if(((Chip)findViewById(R.id.FunkyFluids)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.FunkyFluids)).getText()));
        }
        if(((Chip)findViewById(R.id.Grimbergen)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Grimbergen)).getText()));
        }
        if(((Chip)findViewById(R.id.Grodziskie)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Grodziskie)).getText()));
        }
        if(((Chip)findViewById(R.id.Grolsch)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Grolsch)).getText()));
        }
        if(((Chip)findViewById(R.id.Kingpin)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Kingpin)).getText()));
        }
        if(((Chip)findViewById(R.id.Komes)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Komes)).getText()));
        }
        if(((Chip)findViewById(R.id.Komoran)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Komoran)).getText()));
        }
        if(((Chip)findViewById(R.id.Kozel)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Kozel)).getText()));
        }

        if(((Chip)findViewById(R.id.Książęce)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Książęce)).getText()));
        }
        if(((Chip)findViewById(R.id.Miłosław)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Miłosław)).getText()));
        }
        if(((Chip)findViewById(R.id.Moczybroda)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Moczybroda)).getText()));
        }
        if(((Chip)findViewById(R.id.NaJurze)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.NaJurze)).getText()));
        }
        if(((Chip)findViewById(R.id.Nepomucen)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Nepomucen)).getText()));
        }
        if(((Chip)findViewById(R.id.Paulaner)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Paulaner)).getText()));
        }
        if(((Chip)findViewById(R.id.PilsnerUrquell)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.PilsnerUrquell)).getText()));
        }
        if(((Chip)findViewById(R.id.Pinta)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Pinta)).getText()));
        }
        if(((Chip)findViewById(R.id.Primator)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Primator)).getText()));
        }
        if(((Chip)findViewById(R.id.Raduga)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Raduga)).getText()));
        }
        if(((Chip)findViewById(R.id.Recraft)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Recraft)).getText()));
        }
        if(((Chip)findViewById(R.id.TrzechKumpli)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.TrzechKumpli)).getText()));
        }
        if(((Chip)findViewById(R.id.Zatecky)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Zatecky)).getText()));
        }
        if(((Chip)findViewById(R.id.Zamiastem)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Zamiastem)).getText()));
        }
        if(((Chip)findViewById(R.id.Żywiec)).isChecked()==true)
        {
            filtr.add(String.valueOf(((Chip)findViewById(R.id.Żywiec)).getText()));
        }
    }
    public void more(View v) {
        if (w == 0)
        {
            findViewById(R.id.AleBrowar).setVisibility(View.VISIBLE);
            findViewById(R.id.Artezan).setVisibility(View.VISIBLE);
            findViewById(R.id.Amber).setVisibility(View.VISIBLE);
            findViewById(R.id.Brokreacja).setVisibility(View.VISIBLE);
            findViewById(R.id.Budweiser).setVisibility(View.VISIBLE);
            findViewById(R.id.Cieszyn).setVisibility(View.VISIBLE);
            findViewById(R.id.Fortuna).setVisibility(View.VISIBLE);
            findViewById(R.id.FunkyFluids).setVisibility(View.VISIBLE);
            findViewById(R.id.Grimbergen).setVisibility(View.VISIBLE);
            findViewById(R.id.Kingpin).setVisibility(View.VISIBLE);
            findViewById(R.id.Komes).setVisibility(View.VISIBLE);
            findViewById(R.id.Komoran).setVisibility(View.VISIBLE);
            findViewById(R.id.Miłosław).setVisibility(View.VISIBLE);
            findViewById(R.id.Moczybroda).setVisibility(View.VISIBLE);
            findViewById(R.id.NaJurze).setVisibility(View.VISIBLE);
            findViewById(R.id.Nepomucen).setVisibility(View.VISIBLE);
            findViewById(R.id.Primator).setVisibility(View.VISIBLE);
            findViewById(R.id.Raduga).setVisibility(View.VISIBLE);
            findViewById(R.id.Recraft).setVisibility(View.VISIBLE);
            findViewById(R.id.Zatecky).setVisibility(View.VISIBLE);
            findViewById(R.id.Zamiastem).setVisibility(View.VISIBLE);
            w=1;
        }
        else
        {
            findViewById(R.id.AleBrowar).setVisibility(View.GONE);
            findViewById(R.id.Artezan).setVisibility(View.GONE);
            findViewById(R.id.Amber).setVisibility(View.GONE);
            findViewById(R.id.Brokreacja).setVisibility(View.GONE);
            findViewById(R.id.Budweiser).setVisibility(View.GONE);
            findViewById(R.id.Cieszyn).setVisibility(View.GONE);
            findViewById(R.id.Fortuna).setVisibility(View.GONE);
            findViewById(R.id.FunkyFluids).setVisibility(View.GONE);
            findViewById(R.id.Grimbergen).setVisibility(View.GONE);
            findViewById(R.id.Kingpin).setVisibility(View.GONE);
            findViewById(R.id.Komes).setVisibility(View.GONE);
            findViewById(R.id.Komoran).setVisibility(View.GONE);
            findViewById(R.id.Miłosław).setVisibility(View.GONE);
            findViewById(R.id.Moczybroda).setVisibility(View.GONE);
            findViewById(R.id.NaJurze).setVisibility(View.GONE);
            findViewById(R.id.Nepomucen).setVisibility(View.GONE);
            findViewById(R.id.Primator).setVisibility(View.GONE);
            findViewById(R.id.Raduga).setVisibility(View.GONE);
            findViewById(R.id.Recraft).setVisibility(View.GONE);
            findViewById(R.id.Zatecky).setVisibility(View.GONE);
            findViewById(R.id.Zamiastem).setVisibility(View.GONE);
            w=0;
        }



    }


}