package com.example.androiduibasics.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.crashlytics.android.Crashlytics;
import com.example.androiduibasics.R;

public class ButtonComponentExamples extends AppCompatActivity {

    private Button bNormal;
    private ImageButton bImageButton;

    private RadioButton bRadio;
    private Switch bSwitch;
    private ToggleButton bToggle;
    private CheckBox bCheck;

    private FloatingActionButton bFAB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_components);
        initViews();
        initListeners();
    }

    private void initListeners() {
        bNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Crashlytics.log("Hello");
                throw new RuntimeException("Button is null ");
            }
        });

        bNormal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    private void initViews() {

        bNormal = findViewById(R.id.bNormal);
        bImageButton = findViewById(R.id.bImageButton);


        bRadio = findViewById(R.id.bRadio);
        bToggle = findViewById(R.id.bToggle);
        bSwitch = findViewById(R.id.bSwitch);
        bCheck = findViewById(R.id.bCheck);

        bFAB = findViewById(R.id.bFAB);
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
