package com.example.androiduibasics.modal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class SnackBarExample extends AppCompatActivity implements View.OnClickListener{

    private Button button_snackbar_short;
    private Button button_snackbar_long;
    private Button button_snackbar_indeterminate;
    private ConstraintLayout snackBarLayout ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_snackbar_example);
        initViews();
    }


    private void initViews() {

        button_snackbar_short = findViewById(R.id.bShort);
        button_snackbar_long = findViewById(R.id.bLong);
        button_snackbar_indeterminate = findViewById(R.id.bIndeterminate);

        snackBarLayout = findViewById(R.id.snackbar_layout);

        button_snackbar_short.setOnClickListener(this);
        button_snackbar_long.setOnClickListener(this);
        button_snackbar_indeterminate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bShort:
                showShortSnackbar();
                break;


            case R.id.bLong:
                showLongSnackbar();
                break;

            case R.id.bIndeterminate:
                showIndefiniteSnackbar();
                break;

        }

    }

    private void showIndefiniteSnackbar() {
        Snackbar.make(snackBarLayout,R.string.button_text,Snackbar.LENGTH_INDEFINITE).show();

    }

    private void showCustomSnackbar() {

    }

    private void showLongSnackbar() {

        Snackbar.make(snackBarLayout,R.string.button_text,Snackbar.LENGTH_LONG).show();
    }

    private void showShortSnackbar() {

        //1.Show ShortTime Snackbar with snackBar Object
        Snackbar snackbar = Snackbar.make(snackBarLayout,"Short Snackbar",Snackbar.LENGTH_SHORT);

        //2.Show with Action on Snackbar  and then By
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Timber.e("Undo Changes");
            }
        });

        //3.Show Text With Multiple Lines  To Let know how it behaves  and show elipses.
        //4 .Also tell about CordinatorLayout  will have much in snackbar


        //5. If You want to take any action when Snackbar is Show/Dismissed  Use AddCallback ,previouly its
        //setCallback
        snackbar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);

                Timber.e("I am dismissed ");


            }

            @Override
            public void onShown(Snackbar transientBottomBar) {
                super.onShown(transientBottomBar);
                Timber.e("I am Shown ");
            }
        });

        snackbar.show();


    }



}
