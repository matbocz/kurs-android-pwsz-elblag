package com.example.rozmieszczaniekomponentow3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button wyslijButton;
    EditText trescEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trescEditText = findViewById(R.id.trescEditText);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                trescEditText.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            }
        });

        alertDialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                trescEditText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
        });

        alertDialog.create();

        wyslijButton = findViewById(R.id.wyslijButton);
        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}
