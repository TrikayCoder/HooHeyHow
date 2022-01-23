package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.hooheyhow.R;
import com.example.hooheyhow.logic.Logic;
import com.example.hooheyhow.logic.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity implements ResultActivityInterface {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //end
        setContentView(R.layout.activity_result);
        setupVariable();
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("Key_1");
        textView.setText(value1);
    }

    @Override
    public void print() {



    }

    @Override
    public void resetActivity() {

    }

    private void setupVariable(){
        textView = findViewById(R.id.textView);
    }
}