package com.example.hooheyhow.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.hooheyhow.R;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity {
    Animation mAnimationScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //end
        setContentView(R.layout.activity_menu);
        mAnimationScale = AnimationUtils.loadAnimation(this,R.anim.scale);
    }

    public void playGameImageButton(View view) {
        view.startAnimation(mAnimationScale);
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }

    public void howToPlayGameImageButton(View view) {
        view.startAnimation(mAnimationScale);
        Uri uri = Uri.parse("https://www.youtube.com");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void visitTrikayBlogImageButton(View view) {
        view.startAnimation(mAnimationScale);
        Uri uri = Uri.parse("https://trikayblog.blogspot.com/");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}