package com.example.myapplication.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.R;
import com.example.myapplication.data.FiltrationData;
import com.example.myapplication.data.PubData;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.ui.HotPubsFragment;
import com.example.myapplication.ui.SavedFragment;
import com.example.myapplication.ui.SearcherFragment;
import com.example.myapplication.util.SortUtli;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SharedPreferences sp;

    public static final String FILE_NAME = "saved.txt";

    HotPubsFragment hotPubsFragment = new HotPubsFragment();
    SavedFragment savedFragment = new SavedFragment();
    SearcherFragment searcherFragment = new SearcherFragment();

    private ActivityMainBinding binding;
    private String saved;
    private ArrayList<PubData> lista=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_list, R.id.navigation_saved, R.id.navigation_hot_pubs)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //  NavigationUI.setupWithNavController(binding.navView, navController);
        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_list) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, searcherFragment).commit();
                    return true;
                } else {
                    if (item.getItemId() == R.id.navigation_saved) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, savedFragment).commit();
                        return true;
                    } else {
                        if (item.getItemId() == R.id.navigation_hot_pubs) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, hotPubsFragment).commit();
                            return true;
                        }
                    }
                }
                return false;
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final Observer<Integer> name= sort->{
            if(AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().getValue()==1)
            {
                NavigationBar.smoothHide(findViewById(R.id.nav_view));
                LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popUpView=inflater.inflate(R.layout.popuplayout,null);
                PopupWindow popupWindow=new PopupWindow(popUpView,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,true);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        NavigationBar.smoothPopUp(findViewById(R.id.nav_view));
                        if(((Chip)popUpView.findViewById(R.id.trafnosc)).isChecked())
                        {
                            SortUtli sort=new SortUtli();
                            sort.sortUtli(1);
                            ((Chip)(findViewById(R.id.sort))).setText("Trafność");
                        }
                        else
                        {
                            if(((Chip)popUpView.findViewById(R.id.alphabetical)).isChecked())
                            {
                                SortUtli sort=new SortUtli();
                                sort.sortUtli(2);
                                ((Chip)(findViewById(R.id.sort))).setText("Alfabetycznie");

                            }
                            else
                            {
                                if(((Chip)popUpView.findViewById(R.id.rate)).isChecked())
                                {
                                    SortUtli sort=new SortUtli();
                                    sort.sortUtli(3);
                                    ((Chip)(findViewById(R.id.sort))).setText("Najwyższa ocena");
                                }
                                else
                                {
                                    if(((Chip)popUpView.findViewById(R.id.distance)).isChecked())
                                    {
                                        SortUtli sort=new SortUtli();
                                        sort.sortUtli(4);
                                        ((Chip)(findViewById(R.id.sort))).setText("Najbliżej");
                                    }
                                }
                            }
                        }
                    }
                });
                chipslistener(popUpView,popupWindow);


                (findViewById(R.id.search)).post(new Runnable() {
                    @Override
                    public void run() {


                        popupWindow.showAtLocation(findViewById(R.id.search), Gravity.BOTTOM,0,0);
                    }
                });
            }
            else
            {
                if(AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().getValue()==2)
                {
                    NavigationBar.smoothHide(findViewById(R.id.nav_view));
                    LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popUpView=inflater.inflate(R.layout.popup2,null);
                    PopupWindow poPupWindow=new PopupWindow(popUpView,
                            WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.MATCH_PARENT,true);
                    ((TextView)popUpView.findViewById(R.id.PopUpTextView)).setText("Wybierz zakres ocen");
                    poPupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                                RangeSlider slider=(RangeSlider)popUpView.findViewById(R.id.PopUpRanger);
                                if(slider.getValues().get(0)==0 & slider.getValues().get(1)==5) {((Chip)findViewById(R.id.rating)).setChecked(false);}
                                else
                                {

                                    for(PubData pub:AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue())
                                    {
                                        if(pub.getRatingOwn()>slider.getValues().get(0) & pub.getRatingOwn()<slider.getValues().get(1))
                                        {
                                            lista.add(pub);
                                        }
                                        AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().setValue(lista);
                                    }


                                }
                        }
                    });

                    popUpView.findViewById(R.id.dismis).setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {poPupWindow.dismiss();}});
                    (findViewById(R.id.search)).post(new Runnable() {
                        @Override
                        public void run() {


                            poPupWindow.showAtLocation(findViewById(R.id.search), Gravity.BOTTOM,0,0);
                        }
                    });
                }
                else {
                    if (AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().getValue() == 3) {
                        NavigationBar.smoothHide(findViewById(R.id.nav_view));
                        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popUpView = inflater.inflate(R.layout.popup2, null);
                        PopupWindow poPupWindow = new PopupWindow(popUpView,
                                WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT, true);
                        ((TextView) popUpView.findViewById(R.id.PopUpTextView)).setText("Wybierz zakres odległości");
                        poPupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                RangeSlider slider = (RangeSlider) popUpView.findViewById(R.id.PopUpRanger);
                                if (slider.getValues().get(0) == 0 & slider.getValues().get(1) == 5) {
                                    ((Chip) findViewById(R.id.rating)).setChecked(false);
                                } else {

                                    for (PubData pub : AppContainer.getInstance().getPubSearchingContainer().getListOfFiltratedPubs().getValue()) {
                                        if (pub.getDistance() > slider.getValues().get(0) & pub.getDistance() < slider.getValues().get(1)) {
                                            lista.add(pub);
                                        }
                                        AppContainer.getInstance().getPubSearchingContainer().getListOfSortedPubs().setValue(lista);
                                    }


                                }
                            }
                        });

                        popUpView.findViewById(R.id.dismis).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                poPupWindow.dismiss();
                            }
                        });
                        (findViewById(R.id.search)).post(new Runnable() {
                            @Override
                            public void run() {


                                poPupWindow.showAtLocation(findViewById(R.id.search), Gravity.BOTTOM, 0, 0);
                            }
                        });
                    }
                }
            }

        };



        AppContainer.getInstance().getPubSearchingContainer().getPopupInofmation().observe(this,name);
        /*
        final Observer<String> name = save -> {
                if((AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue()).equals(""))
                {
                    load();
                    Log.d("tak",AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue());
                }
                else
                {
                    try {
                        Log.d("tak",AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue());
                        save(AppContainer.getInstance().getPubSearchingContainer().getSavedlist().getValue());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

        };
        AppContainer.getInstance().getPubSearchingContainer().getSavedlist().observe(this, name);

         */

    }

    private void chipslistener(View popUpView,PopupWindow popupWindow)
    {
        (popUpView.findViewById(R.id.alphabetical)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Chip)(popUpView.findViewById(R.id.trafnosc))).setChecked(false);
                ((Chip)(popUpView.findViewById(R.id.rate))).setChecked(false);
                ((Chip)(popUpView.findViewById(R.id.distance))).setChecked(false);
            }
        });

        (popUpView.findViewById(R.id.trafnosc)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Chip)popUpView.findViewById(R.id.alphabetical)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.rate)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.distance)).setChecked(false);
            }
        });
        (popUpView.findViewById(R.id.distance)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Chip)popUpView.findViewById(R.id.alphabetical)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.trafnosc)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.rate)).setChecked(false);
            }
        });
        (popUpView.findViewById(R.id.rate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Chip)popUpView.findViewById(R.id.trafnosc)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.distance)).setChecked(false);
                ((Chip)popUpView.findViewById(R.id.alphabetical)).setChecked(false);
            }
        });

        (popUpView.findViewById(R.id.dismiss)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }


    /*

    public void save(String tosave) throws IOException {
        FileWriter fos=new FileWriter(FILE_NAME,false);
        fos.write(tosave);

        if(fos!=null)
        {
            fos.close();
        }
    }


    public void load()
    {
        FileInputStream fis=null;
        try {
            fis=openFileInput(FILE_NAME);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;

            while((text=br.readLine())!=null)
            {
                sb.append(text).append("\n");

            }

            AppContainer.getInstance().getPubSearchingContainer().getSavedlist().setValue(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException
                    (e);
        }finally {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

     */

}