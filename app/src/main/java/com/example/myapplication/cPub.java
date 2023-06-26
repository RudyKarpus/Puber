package com.example.myapplication;

import java.util.ArrayList;

public class cPub
{
    private String name;
    private String id;
    private int image;
    private String ocenawlasna;
    private String ocenagoog;
    private String ocenaface;
    private String ocenatripa;
    private String ocenauntapped;
    private String odleglosc;
    private String godzinyotwarcia;
    private ArrayList<String> browary;
    private ArrayList<String> drinki;
    private String cena;

    public cPub(String name, String id, int image, String ocenawlasna,String ocenagoog, String ocenaface, String ocenatripa, String ocenauntapped, String odleglosc, String godzinyotwarcia, ArrayList<String> browary, ArrayList<String> drinki, String cena) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.ocenawlasna=ocenawlasna;
        this.ocenagoog = ocenagoog;
        this.ocenaface = ocenaface;
        this.ocenatripa = ocenatripa;
        this.ocenauntapped = ocenauntapped;
        this.odleglosc = odleglosc;
        this.godzinyotwarcia = godzinyotwarcia;
        this.browary = browary;
        this.drinki = drinki;
        this.cena = cena;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOcenawlasna() {
        return ocenawlasna;
    }
    public void setOcenawlasna(String ocenawlasna)
    {
        this.ocenawlasna=ocenawlasna;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getOcenagoog() {
        return ocenagoog;
    }

    public void setOcenagoog(String ocenagoog) {
        this.ocenagoog = ocenagoog;
    }

    public String getOcenaface() {
        return ocenaface;
    }

    public void setOcenaface(String ocenaface) {
        this.ocenaface = ocenaface;
    }

    public String getOcenatripa() {
        return ocenatripa;
    }

    public void setOcenatripa(String ocenatripa) {
        this.ocenatripa = ocenatripa;
    }

    public String getOcenauntapped() {
        return ocenauntapped;
    }

    public void setOcenauntapped(String ocenauntapped) {
        this.ocenauntapped = ocenauntapped;
    }

    public String getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(String odleglosc) {
        this.odleglosc = odleglosc;
    }

    public String getGodzinyotwarcia() {
        return godzinyotwarcia;
    }

    public void setGodzinyotwarcia(String godzinyotwarcia) {
        this.godzinyotwarcia = godzinyotwarcia;
    }

    public ArrayList<String> getBrowary() {
        return browary;
    }

    public void setBrowary(ArrayList<String> browary) {
        this.browary = browary;
    }

    public ArrayList<String> getDrinki() {
        return drinki;
    }

    public void setDrinki(ArrayList<String> drinki) {
        this.drinki = drinki;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
