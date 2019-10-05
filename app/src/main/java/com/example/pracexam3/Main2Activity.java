package com.example.pracexam3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FileInputStream fin = null;
        try {
            fin = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = fin.read()) != -1){
                temp = temp + ((char)token);
            }
            fin.close();
            try {
                String[] list = temp.split("_");
                ((Button) (findViewById(R.id.btn_schl1))).setText(list[0]);
                ((Button) (findViewById(R.id.btn_schl2))).setText(list[1]);
                ((Button) (findViewById(R.id.btn_schl3))).setText(list[2]);
                ((Button) (findViewById(R.id.btn_schl4))).setText(list[3]);
                ((Button) (findViewById(R.id.btn_schl5))).setText(list[4]);
                ((Button) (findViewById(R.id.btn_schl6))).setText(list[5]);
                ((Button) (findViewById(R.id.btn_schl7))).setText(list[6]);
                ((Button) (findViewById(R.id.btn_schl8))).setText(list[7]);
            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void previousPage(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
