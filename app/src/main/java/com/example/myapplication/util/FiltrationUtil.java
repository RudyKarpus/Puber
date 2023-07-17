package com.example.myapplication.util;

import static com.example.myapplication.data.FiltrationConstants.BASE_BOTTOM_RATING;
import static com.example.myapplication.data.FiltrationConstants.BASE_DISTANCE;
import static com.example.myapplication.data.FiltrationConstants.BASE_PRICE;
import static com.example.myapplication.data.FiltrationConstants.BASE_UPPER_RATING;

import com.example.myapplication.data.FiltrationData;
import com.example.myapplication.data.PubData;

import java.util.ArrayList;

import lombok.Getter;

public class FiltrationUtil {


    private FiltrationData filter;
    @Getter
    private ArrayList<PubData> pubDataArrayList;

    public FiltrationUtil(FiltrationData filter, ArrayList<PubData> pubDataArrayList)
    {
        this.filter=filter;
        this.pubDataArrayList=pubDataArrayList;
    }

    public FiltrationUtil  ratingFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(filter.getBottomRating()==BASE_BOTTOM_RATING && filter.getUpperRating()==BASE_UPPER_RATING) {
            return this;
        }
        for(var pubData: pubDataArrayList)
        {
            float average = (pubData.getRatingFacebook() + pubData.getRatingGoogle()
                    + pubData.getRatingTripAdvisor() + pubData.getRatingUntapped()
                    + pubData.getRatingOwn()) / 5;
            if (filter.getBottomRating() <= average && filter.getUpperRating() >= average) {
                filtrated.add(pubData);
            }
        }
        pubDataArrayList=filtrated;
        return this;
    }
    public  FiltrationUtil distanceFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(filter.getDistance()==BASE_DISTANCE) {
            return this;
        }
        for(var pubData: pubDataArrayList) {
            if (filter.getBottomRating() <=pubData.getDistance()) {
                filtrated.add(pubData);
            }
        }
        pubDataArrayList=filtrated;
        return this;
    }

    public  FiltrationUtil breweriesFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(filter.getBreweries().size()==0) {
            return this;
        }
        for(var pubData: pubDataArrayList) {
            tonext:
            for( var brewPub:pubData.getBreweries()) {
                for( var brewFilter:filter.getBreweries()) {
                    if (brewPub.equals(brewFilter) ) {
                        filtrated.add(pubData);
                        break tonext;
                    }
                }
            }

        }
        pubDataArrayList=filtrated;
        return this;
    }
    public  FiltrationUtil drinksFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(filter.getDrinks().size()==0) {
            return this;
        }
        for(var pubData: pubDataArrayList) {
            tonext:
            for( var drinkPub:pubData.getDrinks()) {
                for( var drinkFilter:filter.getDrinks()) {
                    if (drinkPub.equals(drinkFilter) ) {
                        filtrated.add(pubData);
                        break tonext;
                    }
                }
            }

        }
        pubDataArrayList=filtrated;
        return this;
    }
    public  FiltrationUtil priceFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(filter.getPrice().equals(BASE_PRICE)) {
            return this;
        }
        for(var pubData: pubDataArrayList) {
            if (filter.getPrice().equals(pubData.getPrice())) {
                filtrated.add(pubData);
            }
        }
        pubDataArrayList=filtrated;
        return this;
    }
    public  FiltrationUtil isOpenFilter()
    {
        ArrayList<PubData> filtrated=new ArrayList<>();
        if(!filter.isOpen()) {
            return this;
        }
        for(var pubData: pubDataArrayList) {
            if (pubData.getOpeningHours().equals("otwarte")) {
                filtrated.add(pubData);
            }
        }
        pubDataArrayList=filtrated;
        return this;
    }

}
