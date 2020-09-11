package com.example.labs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.labs.FifthLab.FifthLabActivity;
import com.example.labs.FourthLab.Calculation;
import com.example.labs.FourthLab.FourthLabActivity;
import com.example.labs.SixthLab.SettingsActivity;
import com.example.labs.ThirdLab.ThirdLabActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText et_number1, et_number2;
    private final Drawable [] colorsActionBar = {new ColorDrawable(Color.BLUE), new ColorDrawable(Color.GREEN), new ColorDrawable(Color.YELLOW)};
    private final int [] colorsActivity = {R.color.colorWhite, R.color.colorLime, R.color.colorOrange, R.color.colorGreen};
    private SharedPreferences def_pref;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        et_number1 = findViewById(R.id.et_number1);
        et_number2 = findViewById(R.id.et_number2);
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_4LR_List :
                startActivity(new Intent(this, FourthLabActivity.class));
                break;
            case R.id.action_settings:
                startActivityForResult(new Intent(MainActivity.this, SettingsActivity.class),1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            int colorIndex = Integer.parseInt(def_pref.getString("ColorActionBar", "0"));
            getSupportActionBar().setBackgroundDrawable(colorsActionBar[colorIndex]);
            colorIndex = Integer.parseInt(def_pref.getString("ColorActivity", "0"));
            LinearLayout rootLL = findViewById(R.id.root_ll);
            rootLL.setBackgroundColor(getResources().getColor(colorsActivity[colorIndex]));
            }
    }


    public void onClickCalculate(View view) {
        if (checkInputFields()) {
            int a = Integer.parseInt(et_number1.getText().toString());
            int b = Integer.parseInt(et_number2.getText().toString());
            Toast.makeText(view.getContext(), String.format(Locale.getDefault(), "%d + %d = %d", a, b, a+b), Toast.LENGTH_SHORT).show();
            viewModel.insertCalculation(new Calculation(a, b, a+b));
        }
    }

    private boolean checkInputFields(){
        if (et_number1.length()==0) {
            Toast.makeText(this, "Введите первое число", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_number2.length()==0) {
            Toast.makeText(this, "Введите второе число", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void onClickOpen2Lab(View view) {
        Intent intent = new Intent(this, SecondLabActivity.class);
        startActivity(intent);
    }

    public void onClickOpen3Lab(View view) {
        Intent intent = new Intent(this, ThirdLabActivity.class);
        startActivity(intent);
    }

    public void onClickOpen5Lab(View view) {
        Intent intent = new Intent(this, FifthLabActivity.class);
        startActivity(intent);
    }

}
