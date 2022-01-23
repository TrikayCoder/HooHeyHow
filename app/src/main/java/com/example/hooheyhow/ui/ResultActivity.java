package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hooheyhow.R;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity implements ResultActivityInterface {
    TextView resultDetailPlayerTextView;
    ImageView resultFinalImageView01, resultFinalImageView02, resultFinalImageView03;

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
        String value1 = intent.getStringExtra("Final_Result");
        int result1 = intent.getIntExtra("Result_01",0);
        int result2 = intent.getIntExtra("Result_02",0);
        int result3 = intent.getIntExtra("Result_03",0);
        resultDetailPlayerTextView.setText(value1);
    }

    @Override
    public void print() {



    }

    @Override
    public void resetActivity() {

    }

    private void setupVariable(){
        resultDetailPlayerTextView = findViewById(R.id.resultDetailPlayerTextView);
        resultFinalImageView01 = findViewById(R.id.resultFinalImageView01);
        resultFinalImageView02 = findViewById(R.id.resultFinalImageView02);
        resultFinalImageView03 = findViewById(R.id.resultFinalImageView03);
    }
}