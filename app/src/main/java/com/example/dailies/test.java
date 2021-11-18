package com.example.dailies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    private TextView tvvvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_todo);

        tvvvv = findViewById(R.id.tvvvv);
        Intent i = getIntent();

        tvvvv.setText(i.getStringExtra("name"));

    }
}
