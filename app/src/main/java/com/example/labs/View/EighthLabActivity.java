package com.example.labs.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.example.labs.R;

public class EighthLabActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_lab);
        img = findViewById(R.id.imageView);
    }

    public void doTranslateAnimation(View view){
        Animation tr = AnimationUtils.loadAnimation(this, R.anim.translasiya);
        tr.setInterpolator(new AccelerateInterpolator(2.5f));
        img.startAnimation(tr);
    }

    public void doRotateAnimation(View view){
       Animation rotation = AnimationUtils.loadAnimation(this, R.anim.povorot);
        img.startAnimation(rotation);
    }

    public void doScaleAnimation(View view){
        Animation mash = AnimationUtils.loadAnimation(this, R.anim.mashtab);
        img.startAnimation(mash);
    }

    public void doAlphaAnimation(View view){
        Animation al = AnimationUtils.loadAnimation(this, R.anim.alpha);
        img.startAnimation(al);
    }
}