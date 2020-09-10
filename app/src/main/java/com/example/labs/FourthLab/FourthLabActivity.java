package com.example.labs.FourthLab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.labs.MainViewModel;
import com.example.labs.R;

public class FourthLabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_lab);

        RecyclerView recyclerView;
        DataAdapter adapter;
        MainViewModel viewModel;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        adapter = new DataAdapter(viewModel.getCalculations());
        recyclerView.setAdapter(adapter);
    }

}
