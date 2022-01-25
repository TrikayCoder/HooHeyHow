package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hooheyhow.R;
import com.example.hooheyhow.logic.Logic;
import com.example.hooheyhow.logic.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ChooseActivity extends AppCompatActivity implements ChooseActivityInterface {
    ImageView imageView;
    Animation mAnimationScale;
    TextView playerDetailTextView;
    Logic mLogic;
    ArrayList<Player> player = new ArrayList<>();
    ArrayList<Integer> playerData = new ArrayList<>();
    static int playerTH = 1;
    static int tiger = 0;
    static int chicken = 0;
    static int fish = 0;
    static int shrimp = 0;
    static int crab = 0;
    static int calabash = 0;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //end
        setContentView(R.layout.activity_choose);
        mLogic = new Logic();
        mAnimationScale = AnimationUtils.loadAnimation(this,R.anim.scale);
        setupVariable();
        setupArrayList();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void print() {
        int money = tiger + chicken + fish + shrimp + crab + calabash;
        String detailTemp = Integer.toString(money);
        String sPlayerTH = Integer.toString(playerTH);
        playerDetailTextView.setText("Player " + sPlayerTH + ": " + detailTemp +"vnd");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void resetActivityLv1() {
        tiger = 0;
        chicken = 0;
        fish = 0;
        shrimp = 0;
        crab = 0;
        calabash = 0;
        playerDetailTextView.setText("Mời bạn đặt tiền ở bên trên");
        for(int i=0;i<6;i++){
            playerData.set(i,0);
        }

    }

    @Override
    public void resetActivityLv2() {
        playerTH = 1;
        player.clear();
    }

    @SuppressLint("SetTextI18n")
    public void chooseAnimalImageButton(View view) {
        if(view.getId() == R.id.randomTigerImageButton){
            tiger += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(0,tiger);
        }else if(view.getId() == R.id.randomChickenImageButton) {
            chicken += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(1, chicken);
        }else if(view.getId() == R.id.randomCalabashImageButton) {
            calabash += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(2, calabash);
        }else if(view.getId() == R.id.randomCrabImageButton) {
            crab += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(3, crab);
        }else if(view.getId() == R.id.randomFishImageButton) {
            fish += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(4, fish);
        }else if(view.getId() == R.id.randomShrimpImageButton) {
            shrimp += 5000;
            view.startAnimation(mAnimationScale);
            playerData.set(5, shrimp);
        }
        print();
    }


    public void nextPlayerImageButton(View view) {
        playerTH++;
        Player temp = new Player(playerData);
        player.add(temp);
        view.startAnimation(mAnimationScale);
        resetActivityLv1();
    }



    public void startGameImageButton(View view) {
        int result1 = mLogic.makeRandom() - 1;
        int result2 = mLogic.makeRandom() - 1;
        int result3 = mLogic.makeRandom() - 1;
        String finalResult = mLogic.logicResult(result1,result2,result3,player);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Final_Result", finalResult);
        intent.putExtra("Result_01", result1);
        intent.putExtra("Result_02", result2);
        intent.putExtra("Result_03", result3);
        view.startAnimation(mAnimationScale);
        resetActivityLv2();
        startActivity(intent);
    }


    private void setupArrayList(){
        playerData.add(0);
        playerData.add(0);
        playerData.add(0);
        playerData.add(0);
        playerData.add(0);
        playerData.add(0);
    }

    private void setupVariable(){
        playerDetailTextView = findViewById(R.id.playerDetailTextView);
    }
}