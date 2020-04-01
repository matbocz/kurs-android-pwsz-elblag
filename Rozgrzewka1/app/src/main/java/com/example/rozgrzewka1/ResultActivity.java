package com.example.rozgrzewka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        String imieString = intent.getStringExtra(MainActivity.EXTRA_IMIE);
        String nazwiskoString = intent.getStringExtra(MainActivity.EXTRA_NAZWISKO);

        TextView imieTextView = findViewById(R.id.imieTextView);
        TextView nazwiskoTextView = findViewById(R.id.nazwiskoTextView);

        imieTextView.setText("Imie: " + imieString);
        nazwiskoTextView.setText("Nazwisko: " + nazwiskoString);
    }
}
