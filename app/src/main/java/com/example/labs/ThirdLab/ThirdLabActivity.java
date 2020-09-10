package com.example.labs.ThirdLab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.labs.R;

public class ThirdLabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_lab);
    }

    public void onClickButtonFirstFragment(View view){
        startActivity(new Intent(this, ThirdLabActivityWithFragment_1.class));
    }

    public void onClickButtonSecondFragment(View view){
        startActivity(new Intent(this, ThirdLabActivityWithFragment_2.class));
    }

}
