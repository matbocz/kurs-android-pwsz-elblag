package com.example.rozmieszczaniekomponentow4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    static TextView resultTextView;

    public static final String DATE_DIALOG_LEFT = "LeftDatePicker";
    static TextView leftTextView;
    private Button leftButton;
    private static int leftYear;
    private static int leftMonth;
    private static int leftDay;

    public static final String DATE_DIALOG_RIGHT = "RightDatePicker";
    static TextView rightTextView;
    private Button rightButton;
    private static int rightYear;
    private static int rightMonth;
    private static int rightDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        leftTextView = findViewById(R.id.leftTextView);
        leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment leftFragment = new DatePickerFragmentLeft();
                leftFragment.show(getSupportFragmentManager(), DATE_DIALOG_LEFT);
            }
        });

        rightTextView = findViewById(R.id.rightTextView);
        rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment rightFragment = new DatePickerFragmentRight();
                rightFragment.show(getSupportFragmentManager(), DATE_DIALOG_RIGHT);
            }
        });
    }

    public static class DatePickerFragmentLeft extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), R.style.LeftDatePicker, this, year, month, day);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onDateSet(DatePicker view, int year, int month, int day) {
            leftYear = year;
            leftMonth = month;
            leftDay = day;

            leftTextView.setText(new StringBuilder()
                    .append(leftYear).append("-")
                    .append(leftMonth + 1).append("-")
                    .append(leftDay).append(" "));

            if (rightTextView.getText().toString().trim().length() > 0) {
                LocalDate leftDate = LocalDate.of(leftYear, leftMonth, leftDay);
                LocalDate rightDate = LocalDate.of(rightYear, rightMonth, rightDay);

                long daysBetween = ChronoUnit.DAYS.between(leftDate, rightDate);
                long monthsBetween = ChronoUnit.MONTHS.between(leftDate, rightDate);
                long yearsBetween = ChronoUnit.YEARS.between(leftDate, rightDate);

                if (daysBetween < 0 || monthsBetween < 0 || yearsBetween < 0) {
                    resultTextView.setText("Prawa data jest wcześniejsza od lewej. Zmień daty!" + "\n\nRóżnica lat = " + 0 + "\nRóżnica miesięcy = " + 0 + "\nRóżnica dni = " + 0);
                } else {
                    resultTextView.setText("Różnica lat = " + yearsBetween + "\nRóżnica miesięcy = " + monthsBetween + "\nRóżnica dni = " + daysBetween);
                }
            } else {
                resultTextView.setText("Wybierz prawą datę!");
            }
        }
    }

    public static class DatePickerFragmentRight extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), R.style.RightDatePicker, this, year, month, day);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onDateSet(DatePicker view, int year, int month, int day) {
            rightYear = year;
            rightMonth = month;
            rightDay = day;

            rightTextView.setText(new StringBuilder()
                    .append(rightYear).append("-")
                    .append(rightMonth + 1).append("-")
                    .append(rightDay).append(" "));

            if (leftTextView.getText().toString().trim().length() > 0) {
                LocalDate leftDate = LocalDate.of(leftYear, leftMonth, leftDay);
                LocalDate rightDate = LocalDate.of(rightYear, rightMonth, rightDay);

                long daysBetween = ChronoUnit.DAYS.between(leftDate, rightDate);
                long monthsBetween = ChronoUnit.MONTHS.between(leftDate, rightDate);
                long yearsBetween = ChronoUnit.YEARS.between(leftDate, rightDate);

                if (daysBetween < 0 || monthsBetween < 0 || yearsBetween < 0) {
                    resultTextView.setText("Prawa data jest wcześniejsza od lewej. Zmień daty!" + "\n\nRóżnica lat = " + 0 + "\nRóżnica miesięcy = " + 0 + "\nRóżnica dni = " + 0);
                } else {
                    resultTextView.setText("Różnica lat = " + yearsBetween + "\nRóżnica miesięcy = " + monthsBetween + "\nRóżnica dni = " + daysBetween);
                }
            } else {
                resultTextView.setText("Wybierz lewą datę!");
            }
        }
    }
}
