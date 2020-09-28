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


public class SecondBlankFragment extends Fragment {
    private EditText et_name, et_surname;
    public SecondBlankFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_blank, container, false);
        et_name = view.findViewById(R.id.et_Name);
        et_surname = view.findViewById(R.id.et_Surname);
        Button btn = view.findViewById(R.id.b_done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInputFields(view)) {
                    String str = String.format(Locale.getDefault(), "Здравствуйте, %s %s. Приятно познакомиться", et_name.getText().toString(), et_surname.getText().toString());
                    Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    private boolean checkInputFields(View view) {
        if (et_name.length() == 0) {
            Toast.makeText(view.getContext(), "Введите имя", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_surname.length() == 0) {
            Toast.makeText(view.getContext(), "Введите фамилию", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
