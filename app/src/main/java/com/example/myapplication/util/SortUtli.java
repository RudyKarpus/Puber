package com.example.myapplication.util;

import android.util.Log;

import com.example.myapplication.app.AppContainer;
import com.example.myapplication.data.PubData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SortUtli
{

    private List<PubData> list;


    public SortUtli sortUtli(int sorting)
    {
        switch(sorting)
        {
            case 1:

            case 2:

                list= AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue();
                Collections.sort(list, new Comparator<PubData>() {
                    @Override
                    public int compare(final PubData object1, final PubData object2) {
                        return (((object1.getName()).toLowerCase())).compareTo((object2.getName().toLowerCase()));
                    }
                });

                AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().setValue(list);


            case 3:
                list= AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue();
                Collections.sort(list, new Comparator<PubData>() {
                    @Override
                    public int compare(final PubData object1, final PubData object2) {
                        if(object1.getRatingOwn()>object2.getRatingOwn())
                        {
                            return 1;
                        }
                        else
                            if(object1.getRatingOwn()==object2.getRatingOwn())
                            {
                                return 0;
                            }
                            else return -1;
                    }
                });
                AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().setValue(list);

            case 4:
                list= AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue();
                Collections.sort(list, new Comparator<PubData>() {
                    @Override
                    public int compare(final PubData object1, final PubData object2) {
                        if(object1.getDistance()>object2.getDistance())
                        {
                            return 1;
                        }
                        else
                        if(object1.getDistance()==object2.getDistance())
                        {
                            return 0;
                        }
                        else return -1;
                    }
                });
                AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().setValue(list);
        }







        return this;
    }
}
