package com.example.listy1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> dane = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dane.add("styczen");
        dane.add("luty");
        dane.add("marzec");
        dane.add("kwiecien");
        dane.add("maj");
        dane.add("czerwiec");
        dane.add("lipiec");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dane);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(MainActivity.this, dane.get(position), Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

    public void addToList(View view) {
        EditText editText = findViewById(R.id.edit_text);
        String text = String.valueOf(editText.getText());

        dane.add(text);
        adapter.notifyDataSetChanged();
    }
}
