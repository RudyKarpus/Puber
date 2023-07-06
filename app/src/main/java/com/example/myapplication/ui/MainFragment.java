package com.example.myapplication.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.app.NavigationBar;

public class MainFragment extends Fragment {

    public MainFragment() {
        super(R.layout.choice);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ((Button) requireView().findViewById(R.id.choice)).setOnClickListener(v->{
            Navigation.findNavController(v).navigate(MainFragmentDirections.mainToSearcher());
        });
        getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        if(getActivity().findViewById(R.id.nav_view).getVisibility()==View.VISIBLE)
            NavigationBar.smoothHide(getActivity().findViewById(R.id.nav_view));
    }
}