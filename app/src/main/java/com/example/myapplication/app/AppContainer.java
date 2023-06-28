package com.example.myapplication.app;

import com.example.myapplication.data.PubSearchingContainer;

import lombok.Getter;


public final class AppContainer {
   private static  AppContainer INSTANCE=null;
   @Getter
   private PubSearchingContainer pubSearchingContainer;
   private AppContainer()
   {
      pubSearchingContainer=new PubSearchingContainer();
   }
   public static synchronized AppContainer getInstance()
   {
      if(INSTANCE==null)
         INSTANCE=new AppContainer();
      return INSTANCE;
   }
}
