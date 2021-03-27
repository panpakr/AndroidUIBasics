package com.example.androiduibasics.modal;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class DialogTestingActivity extends AppCompatActivity implements View.OnClickListener,DialogExample.onDialogClickListener{

    private Button bDialogShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_testing);
        initViews();
    }

    private void initViews() {

        bDialogShow = findViewById(R.id.bDialog);
        bDialogShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.bDialog) {

            DialogFragment dialogExample = new DialogExample();
            dialogExample.show(getSupportFragmentManager(), "HelloDialog");
        }


    }

    @Override
    public void onClickPositive() {

        Timber.e("Clicked Ok ");

    }

    @Override
    public void onClicknegative() {
        Timber.e("Clicked Not Ok  ");

    }
}
