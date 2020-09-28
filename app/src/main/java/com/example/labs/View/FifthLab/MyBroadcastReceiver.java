package com.example.labs.View.FifthLab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.labs.ViewModel.ViewModelFileOperations;

public class MyBroadcastReceiver extends BroadcastReceiver {

    AppCompatActivity activity;
    public MyBroadcastReceiver(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ViewModelFileOperations viewModelFileOperations = ViewModelProviders.of(activity).get(ViewModelFileOperations.class);
        String result = intent.getStringExtra(MyIntentService.EXTRA_KEY_OUT);
        Toast.makeText(context,  result, Toast.LENGTH_LONG).show();
        viewModelFileOperations.writeFile (result+"\n");

    }
}

