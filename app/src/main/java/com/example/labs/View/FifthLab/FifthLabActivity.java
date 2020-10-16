package com.example.labs.View.FifthLab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labs.R;
import com.example.labs.ViewModel.MyBroadcastReceiver;
import com.example.labs.ViewModel.MyIntentService;
import com.example.labs.ViewModel.ViewModelFileOperations;


public class FifthLabActivity extends AppCompatActivity {
    private TextView tv_fileContent;
    private EditText et_number;
    private MyBroadcastReceiver mMyBroadcastReceiver;
    private ViewModelFileOperations viewModelFileOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_lab);

        viewModelFileOperations = ViewModelProviders.of(this).get(ViewModelFileOperations.class);
        et_number = findViewById(R.id.et_num);
        tv_fileContent = findViewById(R.id.tv_fileContent);
        mMyBroadcastReceiver = new MyBroadcastReceiver(this);
        // регистрируем BroadcastReceiver
        IntentFilter intentFilter = new IntentFilter(MyIntentService.ACTION_MYINTENTSERVICE);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(mMyBroadcastReceiver, intentFilter);
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyBroadcastReceiver);
    }


    // кнопка "Открыть ссылку"
    public void onClickOpenUrl(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"));
        Intent chooser = Intent.createChooser(intent, "Выберите браузер");
        startActivity(chooser);
    }

    // Запуск службы. Кнопка "Вычислить"
    public void onClickCalc(View view) {
        if (checkInputFields()) {
            Intent intentMyIntentService = new Intent(this, MyIntentService.class);
            intentMyIntentService.putExtra("number", Integer.parseInt(et_number.getText().toString()));
            startService(intentMyIntentService);
        }
    }

    // Проверка полей ввода на корректность
    private boolean checkInputFields(){
        if (et_number.length() == 0) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }

    // кнопка "Показать содержимое txt файла"
    public void onClickLoadFromFile(View view){
        String content = viewModelFileOperations.readFile();
        tv_fileContent.setText(content);
    }


}
