package com.example.stk3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch switchButton = findViewById(R.id.switchButton);
        final TextView textView1 = findViewById(R.id.colorTextView);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchButton.setText("Wyłącz");
                    textView1.setBackgroundColor(Color.parseColor("#00BFFF"));
                } else {
                    switchButton.setText("Włącz");
                    textView1.setBackgroundColor(Color.parseColor("#DC143C"));
                }
            }
        });
    }
}
