package com.example.androiduibasics.themes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.androiduibasics.R;


public class StyleSampleImplementation extends AppCompatActivity {

    private Button button_style;

    //Show existing Res Directory For android - Layout/mipmap/drawable

    //1.Show How to make Landscape Layout  Taking two buttons
    //2. Show How to make  Without-Using Resource / Using Resource in XML  / Using Resource in Code
    // /Using Resource With Style

    //3. Finally shows Values String xml for locale



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_style_sample);
        initViews();

    }


    private void initViews() {

        button_style = findViewById(R.id.button_style_code);

        button_style.setText(getString(R.string.button_text));
        button_style.setTextColor(getResources().getColor(R.color.colorAccent));
        button_style.setWidth(200);

    }
}
