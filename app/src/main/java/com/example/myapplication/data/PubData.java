package com.example.myapplication.data;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PubData
{
    private String name;
    private String id;
    private int image;
    private float ratingOwn;
    private float ratingGoogle;
    private float ratingFacebook;
    private float ratingTripAdvisor;
    private float ratingUntapped;
    private float distance;
    private String openingHours;
    private ArrayList<String> breweries;
    private ArrayList<String> drinks;
    private String prices;


}
