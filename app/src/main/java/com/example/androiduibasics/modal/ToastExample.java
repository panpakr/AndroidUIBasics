package com.example.androiduibasics.modal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.androiduibasics.R;

public class ToastExample extends AppCompatActivity  implements View.OnClickListener {

    private Button button_toast_short;
    private Button button_toast_long;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toast_example);
        initViews();
    }


    private void initViews() {

        button_toast_short = findViewById(R.id.b_short);
        button_toast_long = findViewById(R.id.b_long);

        button_toast_long.setOnClickListener(this);
        button_toast_short.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.b_short:
                showShortToast();
                break;


            case R.id.b_long:
                showLongToast();
                showCustomToast();
                break;

        }

    }

    private void showCustomToast() {


        //3.Custom toast without setView Try
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup parent = findViewById(R.id.custom_search);

        View view = layoutInflater.inflate(R.layout.custom_search_toolbar,parent);

        Toast toastCustom = new Toast(this);
        toastCustom.setDuration(Toast.LENGTH_LONG);
        toastCustom.setGravity(Gravity.CENTER_HORIZONTAL,0,100);
        toastCustom.setView(view);
        toastCustom.show();

    }

    private void showLongToast() {

        //2.Show Direct way of  Using Show ,without creating  Object //Inline
        Toast.makeText(this,R.string.drawer_close,Toast.LENGTH_LONG).show();
    }

    private void showShortToast() {

        //1.Make Toast has two Function overload
        Toast toast = Toast.makeText(this,"Hello Toast ",Toast.LENGTH_SHORT);
        toast.show();

    }
}

