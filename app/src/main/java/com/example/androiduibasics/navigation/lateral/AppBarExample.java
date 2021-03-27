package com.example.androiduibasics.navigation.lateral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androiduibasics.R;

public class AppBarExample  extends AppCompatActivity {

    //Use Tool Bar first with svh icon for Hamburger menu

    //1. Show first With AppCompatActivity and show the problem
    //2. To resolve this problem use Activity  or
    //3. Change the style from Theme.AppCompat.Light.DarkActionBar  to Theme.AppCompat.Light.NoActionBar


    private TextView appBarTitle;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_appbar_example);
        initViews();
       // setUpAppBar();
    }

    private void setUpAppBar() {
        appBarTitle.setText("AppBarExample");

        ActionBar actionBar = getSupportActionBar();



    }

    private void initViews() {

        appBarTitle = findViewById(R.id.appbarTitle);
    }
}
