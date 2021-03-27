package com.example.androiduibasics.navigation.lateral;

import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androiduibasics.R;

import timber.log.Timber;

import static android.support.design.widget.TabLayout.*;

public class TabsExample extends AppCompatActivity {


    private TextView appBarTitle;
    private TabLayout tabLayout;

    //1.First Show usage of Tablayout inside app bar Layout
    //2. Show tabs programatically first
    //3. then show Xml Side TabItem

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_bar_example);
        initViews();
        setUpAppBar();
        setUpTabs();

    }

    private void setUpTabs() {

        final Tab  tab1 = tabLayout.newTab();
        tab1.setText("Home");
        tabLayout.addTab(tab1);

        Tab  tab2 = tabLayout.newTab();
        tab2.setText("Profile");
        tab2.setIcon(R.drawable.ic_baseline_menu_24px);
        tabLayout.addTab(tab2);

        Tab  tab3 = tabLayout.newTab();
        tab3.setText("Videos");
        tab3.setIcon(android.R.drawable.ic_menu_view);
        tabLayout.addTab(tab3);

        tabLayout.addOnTabSelectedListener(new BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {

                if(tab == tab1) {
                    Timber.d("Tab Home Selected");
                }

            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });



    }

    private void setUpAppBar() {


        appBarTitle.setText("My Tabs");





    }

    private void initViews() {

        appBarTitle = findViewById(R.id.appbarTitle);
        tabLayout = findViewById(R.id.tabs);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
