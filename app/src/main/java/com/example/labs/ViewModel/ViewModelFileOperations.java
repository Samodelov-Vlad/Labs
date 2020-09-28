package com.example.labs.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ViewModelFileOperations extends AndroidViewModel {
    private static String FILE_NAME = "file";

    public ViewModelFileOperations(@NonNull Application application) {
        super(application);
    }

    // чтение из файла
    public String readFile() {
        StringBuilder strRes = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getApplication().openFileInput(FILE_NAME)));
            String str = "";
            while ((str = br.readLine()) != null) {
                strRes.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strRes.toString();
    }

    // запись в файл
    public void writeFile(String str) {
        try {
            getApplication();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    getApplication().openFileOutput(FILE_NAME, Context.MODE_PRIVATE | Context.MODE_APPEND)));
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}