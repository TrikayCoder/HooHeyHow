package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.hooheyhow.R;
import com.example.hooheyhow.logic.LogicInterface;
import com.example.hooheyhow.logic.Player;

import java.util.ArrayList;
import java.util.Objects;

public class ChooseActivity extends AppCompatActivity implements ChooseActivityInterface {
    ImageView imageView;
    LogicInterface mLogic;
    ArrayList<Player> player = new ArrayList<>();
    ArrayList<Integer> playerData = new ArrayList<>();
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //end
        setContentView(R.layout.activity_choose);

    }

    @Override
    public void print(Object obj) {

    }

    @Override
    public void resetActivity() {

    }

    public void chooseAnimalImageButton(View view) {

    }


    public void nextPlayerImageButton(View view) {
        player.add(new Player(playerData));

    }
}