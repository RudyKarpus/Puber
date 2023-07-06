package com.example.myapplication.data;



import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*

Z wiekszym użyciem Lomboka wygladałoby to  tak
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class FiltrationData {
    private final float bottomRating;
    private final float upperRating;
    private final float distance;//in kilometers
    private final boolean isOpen;
    private final ArrayList<String> breweries;
    private final ArrayList<String> drinks;
    private final float upPrice;
}
 */
@Getter
@Setter
@EqualsAndHashCode
public class FiltrationData  {
    private final float bottomRating;
    private final float upperRating;
    private final float distance;//in kilometers
    private final boolean isOpen;
    private final List<String> breweries;
    private final List<String> drinks;
    private final String price ;

    public static class Builder {

        private float bottomRating=0.0f;
        private float upperRating=5.0f;
        private float distance=20.0f;//in kilometers

        private boolean isOpen=false;
        private List<String> breweries=new ArrayList<>();
        private List<String> drinks=new ArrayList<>();
        private String price ="-$";

        public Builder(){

        }
        public Builder distance(float distance)
        {
            this.distance=distance;
            return this;
        }
        public Builder bottomRating( float bottomRating) {
            this.bottomRating = bottomRating;
            return this;
        }
        public Builder upperRating( float upperRating) {
            this.upperRating = upperRating;
            return this;
        }
        public Builder isOpen( boolean isOpen) {
            this.isOpen = isOpen;
            return this;
        }
        public Builder breweries( List<String> breweries) {
            this.breweries = breweries;
            return this;
        }
        public Builder drinks( List<String> drinks) {
            this.drinks = drinks;
            return this;
        }
        public Builder price( String price) {
            this.price = price;
            return this;
        }
        public FiltrationData build()
        {
            return new FiltrationData(this);
        }
    }

    private FiltrationData(Builder builder)
    {
        bottomRating = builder.bottomRating;
        upperRating = builder.upperRating;
        distance = builder.distance;
        isOpen = builder.isOpen;
        breweries = builder.breweries;
        drinks = builder.drinks;
        price= builder.price;
    }
}
