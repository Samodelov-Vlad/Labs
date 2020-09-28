package com.example.labs.View.SixthLab;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.labs.model.Calculation;

@Database(entities = {Calculation.class}, version = 2, exportSchema = false)
public abstract class CalculationsDatabase extends RoomDatabase {
    private static CalculationsDatabase database;
    private static final String DB_NAME = "calculations.db";
    private static final Object LOCK = new Object();

    public static CalculationsDatabase getInstance(Context context){
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, CalculationsDatabase.class, DB_NAME)
                        .allowMainThreadQueries() // потом удалить
                        .build();
            }
        }
        return database;
    }

    public abstract CalculationsDao calculationsDao();
}

