package com.example.labs.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculations")
public class Calculation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public int num1, num2, sum;

    public Calculation(int id, int num1, int num2, int sum) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.sum = sum;
    }

    @Ignore
    public Calculation(int num1, int num2, int sum) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
