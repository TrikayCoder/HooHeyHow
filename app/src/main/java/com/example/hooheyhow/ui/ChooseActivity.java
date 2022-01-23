package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
    TextView playerDetailTextView;
    Logic mLogic;
    ArrayList<Player> player = new ArrayList<>();
    ArrayList<Integer> playerData = new ArrayList<>();
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
        setupVariable();
        setupArrayList();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void print() {
        int money = tiger + chicken + fish + shrimp + crab + calabash;
        String detailTemp = Integer.toString(money);
        playerDetailTextView.setText(detailTemp +"vnd");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void resetActivity() {
        tiger = 0;
        chicken = 0;
        fish = 0;
        shrimp = 0;
        crab = 0;
        calabash = 0;
        playerDetailTextView.setText("0 vnd");
        for(int i=0;i<6;i++){
            playerData.set(i,0);
        }

    }

    @SuppressLint("SetTextI18n")
    public void chooseAnimalImageButton(View view) {
        if(view.getId() == R.id.randomTigerImageButton){
            tiger += 5000;
            playerData.add(0,tiger);
        }else if(view.getId() == R.id.randomChickenImageButton) {
            chicken += 5000;
            playerData.add(1, chicken);
        }else if(view.getId() == R.id.randomCalabashImageButton) {
            calabash += 5000;
            playerData.add(2, calabash);
        }else if(view.getId() == R.id.randomCrabImageButton) {
            crab += 5000;
            playerData.add(3, crab);
        }else if(view.getId() == R.id.randomFishImageButton) {
            fish += 5000;
            playerData.add(4, fish);
        }else if(view.getId() == R.id.randomShrimpImageButton) {
            shrimp += 5000;
            playerData.add(5, shrimp);
        }
        print();
    }


    public void nextPlayerImageButton(View view) {
        Player temp = new Player(playerData);
        player.add(temp);
        resetActivity();
    }

    public void startGameImageButton(View view) {
        int result1 = mLogic.makeRandom() - 1;
        int result2 = mLogic.makeRandom() - 1;
        int result3 = mLogic.makeRandom() - 1;

        Intent intent = new Intent(this, ResultActivity.class);
//        intent.putExtra("Key_1", s);
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