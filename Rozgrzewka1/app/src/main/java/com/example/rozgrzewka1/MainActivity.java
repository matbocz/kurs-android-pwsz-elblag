package com.example.rozgrzewka1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_IMIE = "com.example.rozmieszczaniekomponentow1.EXTRA_IMIE";
    public static final String EXTRA_NAZWISKO = "com.example.rozmieszczaniekomponentow1.EXTRA_NAZWISKO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button wyslijButton = findViewById(R.id.wyslijButton);
        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText imieEditText = findViewById(R.id.imieEditText);
                EditText nazwiskoEditText = findViewById(R.id.nazwiskoEditText);

                openResultActivity();

                imieEditText.setText("");
                nazwiskoEditText.setText("");
            }
        });
    }

    public void openResultActivity() {
        EditText imieEditText = findViewById(R.id.imieEditText);
        EditText nazwiskoEditText = findViewById(R.id.nazwiskoEditText);

        String imieString = imieEditText.getText().toString();
        String nazwiskoString = nazwiskoEditText.getText().toString();

        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra(EXTRA_IMIE, imieString);
        resultIntent.putExtra(EXTRA_NAZWISKO, nazwiskoString);

        startActivity(resultIntent);
    }
}
