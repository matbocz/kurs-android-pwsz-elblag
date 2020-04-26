package com.example.listy2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView autaListView;
    List<Auto> auta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auta = new ArrayList();
        auta.add(new Auto("Opel", "2006"));
        auta.add(new Auto("Skoda", "2019"));
        auta.add(new Auto("Ford", "2010"));
        auta.add(new Auto("Toyota", "1995"));
        auta.add(new Auto("Volkswagen", "2007"));
        auta.add(new Auto("Fiat", "2010"));

        AutoAdapter autoAdapter = new AutoAdapter(this, auta);

        autaListView = findViewById(R.id.autaListView);
        autaListView.setAdapter(autoAdapter);
    }
}
