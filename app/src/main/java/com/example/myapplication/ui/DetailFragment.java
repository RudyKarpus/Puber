package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.app.NavigationBar;
import com.example.myapplication.util.SliderAdapter;
import com.example.myapplication.data.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment
{
    private ViewPager2 viewPager;


    public DetailFragment() {super(R.layout.detail);}

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        //To ukrywa navigation bar
        NavigationBar.smoothHide(getActivity().findViewById(R.id.nav_view));

        viewPager=requireView().findViewById(R.id.viewPager);
        List<SliderItem> slideritems=new ArrayList<>();
        slideritems.add(new SliderItem(R.drawable.zdjecie1));
        slideritems.add(new SliderItem(R.drawable.zdjecie3));
        slideritems.add(new SliderItem(R.drawable.zdjecie1));
        slideritems.add(new SliderItem(R.drawable.zdjecie3));
        viewPager.setAdapter(new SliderAdapter(slideritems,viewPager));
        invisibleDetails();

    }

    private void invisibleDetails()
    {
        requireView().findViewById(R.id.googleR).setVisibility(View.GONE);
        requireView().findViewById(R.id.fbR).setVisibility(View.GONE);
        requireView().findViewById(R.id.tripR).setVisibility(View.GONE);
    }

    public void visibleDetails(View v)
    {
        requireView().findViewById(R.id.googleR).setVisibility(View.VISIBLE);;
        requireView().findViewById(R.id.fbR).setVisibility(View.VISIBLE);
        requireView().findViewById(R.id.tripR).setVisibility(View.VISIBLE);
    }



}