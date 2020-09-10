package com.example.labs.SixthLab;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.labs.FourthLab.Calculation;


import java.util.ArrayList;
import java.util.List;

@Dao
public interface CalculationsDao {
    @Query("SELECT * FROM calculations")
    List<Calculation> getAllCalculations();

    @Insert
    void insertCalculation(Calculation calculation);

    @Delete
    void deleteCalculation(Calculation calculation);

    @Query("DELETE FROM calculations")
    void deleteAllNotes();
}
