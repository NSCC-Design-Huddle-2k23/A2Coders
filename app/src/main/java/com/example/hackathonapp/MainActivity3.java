package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
    Button bt3;
    TextView t1;
    String TAG = "MAINACTIVITY3";

    DatePickerDialog.OnDateSetListener d1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.tv);
        bt3=findViewById(R.id.bt4);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(a);
                Toast.makeText(MainActivity3.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog d2 = new DatePickerDialog(
                    MainActivity3.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    d1,
                    year,m,d);
                d2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                d2.show();
            }
        });

        d1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int m, int d) {
                m=m+1;

                Log.d(TAG,"onDateSet: dd/mm/yyy" + d + "/" + m + "/" + year);
                String date = d + "/" + m + "/" + year;
                t1.setText(date);
            }
        };

    }
}