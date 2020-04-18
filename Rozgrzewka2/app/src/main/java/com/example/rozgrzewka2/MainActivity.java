package com.example.rozgrzewka2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView firstTextView, secondTextView;
    Button przesunButton;
    int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = 1;

        firstTextView = findViewById(R.id.firstTextView);
        secondTextView = findViewById(R.id.secondTextView);

        przesunButton = findViewById(R.id.przesunButton);
        przesunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (test == 1) {
                    firstTextView.setBackgroundColor(0xFFFF1100);
                    secondTextView.setBackgroundColor(0xFFFFFFFF);

                    test = 0;
                } else {
                    firstTextView.setBackgroundColor(0xFFFFFFFF);
                    secondTextView.setBackgroundColor(0xFFFF1100);

                    test = 1;
                }
            }
        });
    }
}
