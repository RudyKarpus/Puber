package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.FiltrationData;
import com.example.myapplication.data.PubData;
import com.example.myapplication.test_data.TestData;
import com.example.myapplication.util.Adapter;

import java.util.ArrayList;

public class PubberSearcher extends AppCompatActivity {
    public static final String TAG="PubberSearcher";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubber_searcher);
        initList();
        /*
         * Niestety nie mozesz porównywac Stringow poprzez "=="
         * musisz skorzystac z metody equals
         * przeczytaj sobie https://www.scaler.com/topics/difference-between-equals-method-in-java/
         * if(filteredDataTestPubList.get(0).equals("nie"))<=dobrze
         * if(filteredDataTestPubList.get(0)=="nie")<=zle
         */
        final Observer<FiltrationData> nameObserver = new Observer<FiltrationData>() {
            @Override
            public void onChanged(@Nullable final FiltrationData filtration) {
                Log.d(TAG, "onChanged: filtration changed");
                filtrationOfTestDataList(filtration);
            }

        };
        AppContainer.getInstance()
                .getPubSearchingContainer()
                .getFiltrationOfPubs()
                .observe(this,nameObserver);

    }

    /*
    * Usunalem stąd przykladowe dane i przensioslem je do TestData dla przejrzystosci kodu
    */

    private void initList()
    {
        listView=findViewById(R.id.Publista);
        TestData.initDataSets();
        Adapter adapter=new Adapter(getApplicationContext(),0,TestData.getPubDataList());
        listView.setAdapter(adapter);
    }

    //Pobieranie arraylist z filtra na temat wybranych filtrów
    private void filtrationOfTestDataList(FiltrationData filtrationData) {
        ArrayList<PubData> filtrated=new ArrayList<>();
        Log.d(TAG, "filtrationOfTestDataList: filtraion");
        if (filtrationData == null || filtrationData.equals(new FiltrationData.Builder().build())) {
            filtrated=TestData.getPubDataList();

        } else {
            for (PubData pubData : TestData.getPubDataList())
            {
                float average=(pubData.getRatingFacebook()+pubData.getRatingGoogle()
                        +pubData.getRatingTripAdvisor()+pubData.getRatingUntapped()
                        +pubData.getRatingOwn())/5;
                if(filtrationData.getBottomRating()<=average &&  filtrationData.getUpperRating()>=average)
                {
                    Log.d(TAG, "filtrationOfTestDataList: added");
                    filtrated.add(pubData);
                }
            }

        }
        Adapter adapter = new Adapter(getApplicationContext(), 0, filtrated);
        AppContainer.getInstance()
                .getPubSearchingContainer()
                .getListOfFiltratedPubs()
                .setValue(filtrated);
        listView.setAdapter(adapter);

    }
    public void goToPubberFiltration(View v) {
        Intent i=new Intent(this, PubberFiltration.class);
        startActivity(i);
    }


}