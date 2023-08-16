package com.example.myapplication.data;

import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import lombok.Getter;

public class PubSearchingContainer {

/*
* Przechowuje dane ktore moga byc modyfikowane w kazdej chwili
* Live data pokazuje rowniez czy te zmiany zaszly
 */
    @Getter
    private final MutableLiveData<List<PubData>> listOfFiltratedPubs=new MutableLiveData<>();
    @Getter
    private final MutableLiveData<Integer> position=new MutableLiveData<>();
    @Getter
    private final MutableLiveData<String> savedlist=new MutableLiveData<>();
    @Getter
    private final MutableLiveData<FiltrationData> filtrationOfPubs=new MutableLiveData<>();
    @Getter
    private final MutableLiveData<Integer> popupInofmation=new MutableLiveData<>();
    @Getter
    private final MutableLiveData<List<PubData>> listOfSortedPubs=new MutableLiveData<>();
    public PubSearchingContainer()
    {

        listOfFiltratedPubs.setValue(null);
        filtrationOfPubs.setValue(null);
        position.setValue(null);
        savedlist.setValue("");
        popupInofmation.setValue(0);
        listOfSortedPubs.setValue(null);

    }

}
