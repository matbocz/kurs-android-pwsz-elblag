package com.example.rozgrzewka3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView resultTextView;
    EditText firstEditText, secondEditText;
    Button addButton, subButton, multButton, divButton;

    float resultFloat;
    int firstInt, secondInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        firstEditText = findViewById(R.id.firstEditText);
        secondEditText = findViewById(R.id.secondEditText);

        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        multButton = findViewById(R.id.multButton);
        divButton = findViewById(R.id.divButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEditText.length() == 0) {
                    firstEditText.setError("Enter first number!");
                } else if (secondEditText.length() == 0) {
                    secondEditText.setError("Enter second number!");
                } else {
                    firstInt = Integer.parseInt(firstEditText.getText().toString());
                    secondInt = Integer.parseInt(secondEditText.getText().toString());

                    resultFloat = firstInt + secondInt;
                    resultTextView.setText(String.valueOf(resultFloat));
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEditText.length() == 0) {
                    firstEditText.setError("Enter first number!");
                } else if (secondEditText.length() == 0) {
                    secondEditText.setError("Enter second number!");
                } else {
                    firstInt = Integer.parseInt(firstEditText.getText().toString());
                    secondInt = Integer.parseInt(secondEditText.getText().toString());

                    resultFloat = firstInt - secondInt;
                    resultTextView.setText(String.valueOf(resultFloat));
                }
            }
        });

        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEditText.length() == 0) {
                    firstEditText.setError("Enter first number!");
                } else if (secondEditText.length() == 0) {
                    secondEditText.setError("Enter second number!");
                } else {
                    firstInt = Integer.parseInt(firstEditText.getText().toString());
                    secondInt = Integer.parseInt(secondEditText.getText().toString());

                    resultFloat = firstInt * secondInt;
                    resultTextView.setText(String.valueOf(resultFloat));
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEditText.length() == 0) {
                    firstEditText.setError("Enter first number!");
                } else if (secondEditText.length() == 0) {
                    secondEditText.setError("Enter second number!");
                } else {
                    firstInt = Integer.parseInt(firstEditText.getText().toString());
                    secondInt = Integer.parseInt(secondEditText.getText().toString());

                    resultFloat = firstInt / secondInt;
                    resultTextView.setText(String.valueOf(resultFloat));
                }
            }
        });
    }
}