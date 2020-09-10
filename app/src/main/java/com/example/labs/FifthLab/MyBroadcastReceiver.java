package com.example.labs.FifthLab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra(MyIntentService.EXTRA_KEY_OUT);
        Toast.makeText(context,  result, Toast.LENGTH_LONG).show();
    }
}

