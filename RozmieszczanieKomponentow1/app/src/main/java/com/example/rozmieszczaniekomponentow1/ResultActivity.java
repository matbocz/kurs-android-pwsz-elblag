package com.example.rozmieszczaniekomponentow1;

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
        Integer wiekInteger = intent.getIntExtra(MainActivity.EXTRA_WIEK, 0);
        String plecString = intent.getStringExtra(MainActivity.EXTRA_PLEC);

        TextView imieTextView = findViewById(R.id.imieTextView);
        TextView nazwiskoTextView = findViewById(R.id.nazwiskoTextView);
        TextView wiekTextView = findViewById(R.id.wiekTextView);
        TextView plecTextView = findViewById(R.id.plecTextView);

        imieTextView.setText("Imie: " + imieString);
        nazwiskoTextView.setText("Nazwisko: " + nazwiskoString);
        wiekTextView.setText("Wiek: " + wiekInteger);
        plecTextView.setText("Płeć: " + plecString);
    }
}
