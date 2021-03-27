package com.example.androiduibasics.navigation.lateral;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class NavigationDrawerExample extends AppCompatActivity {


    private NavigationView navigationView;
    private Toolbar toolbar;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_drawer);
        initViews();
        setUpAppBar();
        setUpNavigationDrawer();

    }

    private void setUpNavigationDrawer() {


        navigationView.inflateMenu(R.menu.drawer_nav_items);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.search_item)
                    Timber.d("Played Search ");


                return true;
            }
        });
    }

    private void setUpAppBar() {

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionBarDrawerToggle.syncState();



    }


    private void initViews() {

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);


    }
}
