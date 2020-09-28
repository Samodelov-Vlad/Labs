package com.example.labs.View.FifthLab;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Locale;

public class MyIntentService extends IntentService {
    public static final String ACTION_MYINTENTSERVICE = "ru.samodelovvlad.intentservice.RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    String result;

    public MyIntentService() {
        super("myThreadNameDef");
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
        return resultMsg;
    }





}


