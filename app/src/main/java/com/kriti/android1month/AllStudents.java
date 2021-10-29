package com.kriti.android1month;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class AllStudents extends AppCompatActivity {

    DBHelper dbHelper; ArrayList<StudentInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students);

        dbHelper = new DBHelper(this);
        list = dbHelper.getAllData();
    }
}