package com.kriti.android1month;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeFeed extends AppCompatActivity {

    TextView emailText, passwordText;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);

        emailText = findViewById(R.id.displayEmail);
        passwordText = findViewById(R.id.displayPassword);

        sp = getSharedPreferences("user info", MODE_PRIVATE);
        String email = sp.getString("email", "default");
        String password = sp.getString("password", "default");
        
        emailText.setText(email);
        passwordText.setText(password);
    }
}