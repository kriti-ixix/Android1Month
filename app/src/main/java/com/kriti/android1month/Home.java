package com.kriti.android1month;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView emailText = findViewById(R.id.myEmail);
        TextView passwordText = findViewById(R.id.myPassword);

        Intent in = getIntent();
        String email = in.getStringExtra("useremail");
        String password = in.getStringExtra("password");

        emailText.setText(email);
        passwordText.setText(password);
    }
}