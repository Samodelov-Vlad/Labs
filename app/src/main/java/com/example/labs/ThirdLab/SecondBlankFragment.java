package com.example.labs.ThirdLab;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.labs.R;

import java.util.Locale;


public class SecondBlankFragment extends Fragment {

    public SecondBlankFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_blank, container, false);

        Button btn = view.findViewById(R.id.b_done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.format(Locale.getDefault(), "Здравствуйте %s %s. Приятно познакомиться", "Сам", "Влад");
                Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
