package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.hooheyhow.R;

import java.util.Objects;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //end
        setContentView(R.layout.activity_opening);
        //TODO  RUN TIME OPENING SCREEN
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent i = new Intent(OpeningActivity.this, ChooseActivity.class);
                startActivity(i);
                finish(); } }, 3000);
    }
}