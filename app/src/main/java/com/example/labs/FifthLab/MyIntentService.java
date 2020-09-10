package com.example.labs.FifthLab;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.labs.MainActivity;
import com.example.labs.ViewModelFileOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Locale;

public class MyIntentService extends IntentService {
    public static final String ACTION_MYINTENTSERVICE = "ru.samodelovvlad.intentservice.RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    String result;
    ViewModelFileOperations viewModelFileOperations;

    public MyIntentService() {
        super("myThreadNameDef");
    }

    public MyIntentService(AppCompatActivity activity) {
        super("myThreadName");
        viewModelFileOperations = ViewModelProviders.of(activity).get(ViewModelFileOperations.class);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
         int number = intent.getIntExtra("number", 0);
        result = task(number);

        // возвращаем результат
        Intent responseIntent = new Intent();
        responseIntent.setAction(ACTION_MYINTENTSERVICE);
        responseIntent.addCategory(Intent.CATEGORY_DEFAULT);
        responseIntent.putExtra(EXTRA_KEY_OUT, result);
        sendBroadcast(responseIntent);
    }


    public String task(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < Short.MAX_VALUE*10; i++) {
            int a = (int) (Math.random() * 10);
            list.add(a);
        }
        int countOfNum = 0;

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == number) countOfNum++;
        }
        list.clear();
        String resultMsg = String.format(Locale.getDefault(),"Число %d встречается в массиве %d раз.", number, countOfNum);
        viewModelFileOperations.writeFile (resultMsg+"\n");
        return resultMsg;
    }





}


