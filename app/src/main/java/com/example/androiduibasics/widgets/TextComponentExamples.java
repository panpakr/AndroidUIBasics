package com.example.androiduibasics.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class TextComponentExamples extends AppCompatActivity {

    //Show TextView and remove all layout height and width to show min requirements

    private TextView tv_text;

    private EditText et_plain;
    private EditText et_number;
    private EditText et_password;

    private AutoCompleteTextView autoCompleteTextView;
    private CheckedTextView tv_checked;

    private TextInputEditText et_input_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_text_components);
        initViews();

        //To use AutoCompleteTextView
        initAdapter();
        showEditTextFuction();


    }

    private void showEditTextFuction() {

        et_plain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(count>3);


            }

            @Override
            public void afterTextChanged(Editable s) {

                Timber.d("Enable the click button ");
            }
        });



    }

    private void initAdapter() {

          final String[] Languages = {
                "English", "Hindi", "Marathi", "Tamil", "Telugu","Punjabi","Punj"} ;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                             android.R.layout.simple_dropdown_item_1line, Languages);
        autoCompleteTextView.setAdapter(adapter);

   }


    private void initViews() {

        tv_text = findViewById(R.id.tv_text);

        et_plain = findViewById(R.id.et_plain);
        et_number = findViewById(R.id.et_number);
        et_password = findViewById(R.id.et_password);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        tv_checked = findViewById(R.id.tv_checked);

        et_input_text = findViewById(R.id.et_input_text);
    }
}
