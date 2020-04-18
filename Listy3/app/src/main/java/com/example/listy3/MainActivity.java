package com.example.listy3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Flag> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList();
        data.add(new Flag("Polska", R.drawable.poland));
        data.add(new Flag("Stany Zjednoczone", R.drawable.unitedstates));

        FlagAdapter adapter = new FlagAdapter(this, data);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
