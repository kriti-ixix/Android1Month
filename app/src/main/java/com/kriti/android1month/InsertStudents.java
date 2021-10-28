package com.kriti.android1month;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InsertStudents extends AppCompatActivity {

    Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_students);
        insertButton = findViewById(R.id.insertButton);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(InsertStudents.this);
                long result = dbHelper.addData(1, "ABC", 45.0);

                if (result == -1)
                {
                    Toast.makeText(InsertStudents.this, "Values not inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(InsertStudents.this, "Values inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}