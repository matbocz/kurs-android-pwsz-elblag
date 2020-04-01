package com.example.rozmieszczaniekomponentow1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_IMIE = "com.example.rozmieszczaniekomponentow1.EXTRA_IMIE";
    public static final String EXTRA_NAZWISKO = "com.example.rozmieszczaniekomponentow1.EXTRA_NAZWISKO";
    public static final String EXTRA_WIEK = "com.example.rozmieszczaniekomponentow1.EXTRA_WIEK";
    public static final String EXTRA_PLEC = "com.example.rozmieszczaniekomponentow1.EXTRA_PLEC";

    String STRING_PLEC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button wyslijButton = findViewById(R.id.wyslijButton);
        wyslijButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox zgodaCheckBox = findViewById(R.id.zgodaCheckBox);

                if (zgodaCheckBox.isChecked()) {
                    EditText imieEditText = findViewById(R.id.imieEditText);
                    EditText nazwiskoEditText = findViewById(R.id.nazwiskoEditText);
                    EditText wiekEditText = findViewById(R.id.wiekEditText);

                    openResultActivity();

                    imieEditText.setText("");
                    nazwiskoEditText.setText("");
                    wiekEditText.setText("");
                }
            }
        });
    }

    public void openResultActivity() {
        EditText imieEditText = findViewById(R.id.imieEditText);
        EditText nazwiskoEditText = findViewById(R.id.nazwiskoEditText);
        EditText wiekEditText = findViewById(R.id.wiekEditText);

        String imieString = imieEditText.getText().toString();
        String nazwiskoString = nazwiskoEditText.getText().toString();
        Integer wiekInteger = Integer.parseInt(wiekEditText.getText().toString());

        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra(EXTRA_IMIE, imieString);
        resultIntent.putExtra(EXTRA_NAZWISKO, nazwiskoString);
        resultIntent.putExtra(EXTRA_WIEK, wiekInteger);
        resultIntent.putExtra(EXTRA_PLEC, STRING_PLEC);

        startActivity(resultIntent);
    }

    public void wyborPlci(View v) {
        String toastString;

        if (v.getId() == R.id.kobietaRadioButton) {
            toastString = "Kobieta";
            STRING_PLEC = "Kobieta";
        } else {
            toastString = "Mężczyzna";
            STRING_PLEC = "Mężczyzna";
        }

        Toast plecToast = Toast.makeText(this, toastString, Toast.LENGTH_SHORT);
        plecToast.show();
    }
}
