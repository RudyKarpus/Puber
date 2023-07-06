package com.example.myapplication.app;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class NavigationBar {
    public static void smoothPopUp(View nav_bar)
    {
        nav_bar.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(0, 0,  nav_bar.getHeight(), 0);
        animate.setDuration(200);
        animate.setFillAfter(true);
        nav_bar.startAnimation(animate);
    }
    public static void smoothHide(View nav_bar)
    {

        TranslateAnimation animate = new TranslateAnimation(0, 0, 0,  nav_bar.getHeight());
        animate.setDuration(200);
        nav_bar.startAnimation(animate);
        nav_bar.setVisibility(View.GONE);
    }
}
