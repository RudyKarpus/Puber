package com.example.myapplication.test_data;

import com.example.myapplication.R;
import com.example.myapplication.data.PubData;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public class TestData {


    private static ArrayList<String> breweriesSet1;
    private static ArrayList<String> drinksSet1;

    private static ArrayList<String> breweriesSet2;
    private static ArrayList<String> drinksSet2;

    @Getter
    private static ArrayList<PubData> pubDataList;

    /*
    *   Uzylem statycznych metod bys nie musial inicjaizowac za kazdym razem klasy
    */
    
    public static void  initDataSets()
    {
        breweriesSet1 = new ArrayList<>(List.of("Trzech Kumpli","Amber"));
        breweriesSet2 = new ArrayList<>(List.of("Pinta","Fortuna"));

        drinksSet1 = new ArrayList<>(List.of("Mojito","Kamikaze"));
        drinksSet2 = new ArrayList<>(List.of("Mojito","Martini"));

        /*
         * Pomyliłeś w swoich testowych danych id - 1 i 2 dodany pub
         * miały takie same pola id. wiedziałem o tym xd
         */
        pubDataList =new ArrayList<>();
        pubDataList.add(new PubData("Pod Harpią",
                "1", R.drawable.otwarte,
                2, 2,
                2,2,0.7f,"18",
                breweriesSet1,drinksSet1,"$"));
        pubDataList.add(new PubData("Kot ",
                "1", R.drawable.otwarte,
                4.1f, 4.1f, 4.4f,4.4f,
                4.7f,"18",
                breweriesSet2,drinksSet2,"$$$"));

        /*
          * Nie musisz uzywac metody clear w javie arraylisty sa automatycznie usuwane przez
          * Garbage Collector przez co
          * nie dochodzi do memory leakow z ich udzialem.
         */
    }
}
