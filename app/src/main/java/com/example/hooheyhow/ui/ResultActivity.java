package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hooheyhow.R;
import com.example.hooheyhow.logic.Logic;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity implements ResultActivityInterface {
    TextView resultDetailPlayerTextView;
    ImageView resultFinalImageView01, resultFinalImageView02, resultFinalImageView03;
    Logic mLogic;
    Animation mAnimationScale;
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
        mLogic = new Logic();
        mAnimationScale = AnimationUtils.loadAnimation(this,R.anim.scale);
        resetText();
        setResultFinalImageScreen(result1, resultFinalImageView01);
        setResultFinalImageScreen(result2, resultFinalImageView02);
        setResultFinalImageScreen(result3, resultFinalImageView03);
        logicPrint(value1);
    }



    @SuppressLint("UseCompatLoadingForDrawables")
    public void setResultFinalImageScreen(int result, ImageView view){
        if(result == 0){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_tiger));
        }else if(result == 1){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_chicken));
        }else if(result == 2){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_calabash));
        }else if(result == 3){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_crab));
        }else if(result == 4){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_fish));
        }else if(result == 5){
            view.setImageDrawable(getResources().getDrawable(R.drawable.random_shrimp));
        }
    }


    @SuppressLint("SetTextI18n")
    private void addToEditText(String string) {
        resultDetailPlayerTextView.setText("" + resultDetailPlayerTextView.getText() + string);
    }

    public void resetText() {
        resultDetailPlayerTextView.setText("");
    }
    @Override
    public void print(Object obj) {
        String text = (obj != null ? obj.toString() : "null");
        addToEditText(text);
        String debug = text.replace("\n", "\\n");
    }

    @Override
    public void resetActivity() {

    }

    @Override
    public void logicPrint(String finalResult) {
        String[] arrayFinalResult = finalResult.split("\\|");
        for(int i=0;i<arrayFinalResult.length;i++){
            print("Player " +  (i+1) +": ");
            print(arrayFinalResult[i]);
            print("\n");
            print("\n");
        }
    }

    private void setupVariable(){
        resultDetailPlayerTextView = findViewById(R.id.resultDetailPlayerTextView);
        resultFinalImageView01 = findViewById(R.id.resultFinalImageView01);
        resultFinalImageView02 = findViewById(R.id.resultFinalImageView02);
        resultFinalImageView03 = findViewById(R.id.resultFinalImageView03);
    }

    public void gotoChooseActivityImageButton(View view) {
        view.startAnimation(mAnimationScale);
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }

    public void gotoMenuActivityImageButton(View view) {
        view.startAnimation(mAnimationScale);
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}