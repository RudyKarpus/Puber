package com.example.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.R;
import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.FiltrationData;
import com.example.myapplication.data.PubData;
import com.example.myapplication.test_data.TestData;
import com.example.myapplication.util.ListPubAdapter;

import java.util.ArrayList;

public class SearcherFragment extends Fragment {
    public static final String TAG="SearcherFragment";
    private RecyclerView  recyclerView ;
    private ListPubAdapter adapter;

    public SearcherFragment()
    {
        super(R.layout.searcher);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView=(RecyclerView)requireView().findViewById(R.id.Publista);
        TestData.initDataSets();
        adapter=new ListPubAdapter(TestData.getPubDataList());
        recyclerView.setAdapter(adapter);
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
                .observe(getViewLifecycleOwner(),nameObserver);
        //Refresh publist
        ((SwipeRefreshLayout)requireView().findViewById(R.id.swiperefresh)).setOnRefreshListener(()->
        {
            filtrationOfTestDataList(  AppContainer.getInstance()
                    .getPubSearchingContainer()
                    .getFiltrationOfPubs().getValue());
            ((SwipeRefreshLayout)requireView().findViewById(R.id.swiperefresh)).setRefreshing(false);
        });
        //Setting listener to departure to FiltrationScreen
        ((ImageButton) requireView().findViewById(R.id.imageButton)).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(SearcherFragmentDirections.searcherToFiltration());

        });

    }
    /*
    * Usunalem stąd przykladowe dane i przensioslem je do TestData dla przejrzystosci kodu
    */

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
        adapter = new ListPubAdapter( filtrated);
        AppContainer.getInstance()
                .getPubSearchingContainer()
                .getListOfFiltratedPubs()
                .setValue(filtrated);
        recyclerView.setAdapter(adapter);

    }


}