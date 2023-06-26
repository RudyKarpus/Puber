package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class cPubber extends AppCompatActivity {

    public static ArrayList<cPub> Publist=new ArrayList<>();
    private ArrayList<cPub> przefiltrowane=new ArrayList<>();
    private ListView listView;

    public ArrayList<String> arrayList=new ArrayList<>();
    private ArrayList<String> filtr=new ArrayList<>();

    private ArrayList<String> browar=new ArrayList<>();
    private ArrayList<String> drinki=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpubber);
        setupData();
        setupList();
        filtr=getIntent().getStringArrayListExtra("ocena");
        if(filtr.get(0)!="nie")
        {
        }
        else
        {
            arrayList=filtr;
            Filtr();
        }


    }



    private void setupList()
    {
        listView=findViewById(R.id.Publista);

        cAdapter adapter=new cAdapter(getApplicationContext(),0,Publist);
        listView.setAdapter(adapter);
    }

    private void setupData()
    {
        browar.add("Pinta"); browar.add("Amber");
        drinki.add("Mojito"); drinki.add("Kamikaze");
        cPub pub=new cPub("Pod Harpią","1",R.drawable.otwarte,"5","4.3","4.4","4.9","3.0","0.7","18",browar,drinki,"$");
        Publist.add(pub);
        browar.clear();drinki.clear();
        browar.add("Pinta"); browar.add("Fortuna");
        drinki.add("Mojito"); drinki.add("Martini");
        pub=new cPub("Pod","1",R.drawable.otwarte,"3.1","1","4.4","2","3.0","0.7","5",browar,drinki,"$$$");
        Publist.add(pub);
        browar.clear();drinki.clear();
    }

    //Pobieranie arraylist z filtra na temat wybranych filtrów
    private void Filtr()
    {

            if (arrayList.get(0) != arrayList.get(1)) {
                for (cPub pub : Publist) {
                    float srednia = (Float.parseFloat(pub.getOcenaface()) + Float.parseFloat(pub.getOcenagoog()) + Float.parseFloat(pub.getOcenatripa()) + Float.parseFloat(pub.getOcenauntapped()) + Float.parseFloat(pub.getOcenawlasna())) / 5;
                    if (Float.parseFloat(arrayList.get(0)) < srednia && srednia < Float.parseFloat(arrayList.get(1))) {
                        przefiltrowane.add(pub);
                    }
                }
            }
            cAdapter adapter = new cAdapter(getApplicationContext(), 0, przefiltrowane);
            listView.setAdapter(adapter);

    }

    public void filt(View v)
    {
        Intent i=new Intent(this, cPubberFiltry.class);
        startActivity(i);
    }


}