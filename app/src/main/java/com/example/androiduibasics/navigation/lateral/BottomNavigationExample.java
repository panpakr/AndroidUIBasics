package com.example.androiduibasics.navigation.lateral;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class BottomNavigationExample  extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    //Show AHBottomNavigation Later with library

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_navigation);
        initViews();

    }


    private void initViews() {

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_items);



        //Show  How to implement Item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.search_item)
                    Timber.e("Search is called");

                return true;
            }
        });

        //Showing Badge on the navigation View has lot of issue show in here.
        BottomNavigationMenuView firstItem = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) firstItem.getChildAt(0);
        Timber.d(bottomNavigationItemView.toString());

    }
}
