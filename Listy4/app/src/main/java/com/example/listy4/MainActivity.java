package com.example.listy4;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Painter> painters;
    List<Painter> deletedPainters;
    PainterAdapter painterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        painters = new ArrayList();
        painters.add(new Painter("Vincent Van Gogh", R.drawable.gogh, false));
        painters.add(new Painter("Stanisław Wyspiański", R.drawable.wyspianski, false));
        painters.add(new Painter("Jan Matejko", R.drawable.matejko, false));

        painterAdapter = new PainterAdapter(this, painters);
        ListView painterListView = findViewById(R.id.painterListView);
        painterListView.setAdapter(painterAdapter);
    }

    public void deletePainter(View view) {
        deletedPainters = new ArrayList();

        for (int i = 0; i < painters.size(); i++) {
            if (painters.get(i).toDelete == true)
                deletedPainters.add(painters.get(i));
        }

        painters.removeAll(deletedPainters);
        painterAdapter.notifyDataSetChanged();
    }
}
