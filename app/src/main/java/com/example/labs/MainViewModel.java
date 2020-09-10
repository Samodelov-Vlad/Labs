package com.example.labs;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.labs.FourthLab.Calculation;
import com.example.labs.SixthLab.CalculationsDatabase;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static CalculationsDatabase database;
    private List<Calculation> calculations;

    public MainViewModel(@NonNull Application application) {
        super(application);
        database = CalculationsDatabase.getInstance(getApplication());
        calculations = database.calculationsDao().getAllCalculations();
    }

    public List<Calculation> getCalculations() {
        return calculations;
    }

    public void insertCalculation(Calculation calculation) {
        new InsertTask().execute(calculation);
    }

    public void deleteCalculation(Calculation calculation) {
        new DeleteTask().execute(calculation);
    }

    public void deleteAllCalculation() {
        new DeleteAllTask().execute();
    }

    private static class InsertTask extends AsyncTask<Calculation, Void, Void> {
        @Override
        protected Void doInBackground(Calculation... calculations) {
            if (calculations != null && calculations.length >0) {
                database.calculationsDao().insertCalculation(calculations[0]);
            }
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Calculation, Void, Void> {
        @Override
        protected Void doInBackground(Calculation... calculations) {
            if (calculations != null && calculations.length >0) {
                database.calculationsDao().deleteCalculation(calculations[0]);
            }
            return null;
        }
    }

    private static class DeleteAllTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... calculations) {
                database.calculationsDao().deleteAllNotes();
            return null;
        }
    }

}
