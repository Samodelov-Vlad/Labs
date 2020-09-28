package com.example.labs.View.ThirdLab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labs.R;

import java.util.Locale;


public class FirstBlankFragment extends Fragment {
    private EditText et_num1, et_num2;

    public FirstBlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_blank, container, false);
        Button btn = view.findViewById(R.id.btn_calculate);
        et_num1 = view.findViewById(R.id.et_number1);
        et_num2 = view.findViewById(R.id.et_number2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInputFields(view)) {
                    int a = Integer.parseInt(et_num1.getText().toString());
                    int b = Integer.parseInt(et_num2.getText().toString());
                    Toast.makeText(view.getContext(), String.format(Locale.getDefault(), "%d + %d = %d", a, b, a + b), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private boolean checkInputFields(View view) {
        if (et_num1.length() == 0) {
            Toast.makeText(view.getContext(), "Введите первое число", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_num2.length() == 0) {
            Toast.makeText(view.getContext(), "Введите второе число", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
