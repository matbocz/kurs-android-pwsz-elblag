package com.example.listy2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AutoAdapter extends ArrayAdapter<Auto> {
    private Context context;
    private List<Auto> auta;


    public AutoAdapter(@NonNull Context context, @NonNull List<Auto> objects) {
        super(context, R.layout.auto_layout, objects);
        this.context = context;
        auta = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.auto_layout, parent, false);

        TextView nazwaTextView = rowView.findViewById(R.id.nazwaTextView);
        TextView rokTextView = rowView.findViewById(R.id.rokTextView);
        Button okButton = rowView.findViewById(R.id.okButton);

        nazwaTextView.setText(auta.get(position).getNazwa());
        rokTextView.setText(auta.get(position).getRok());

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(context, auta.get(position).getNazwa(), Toast.LENGTH_SHORT);
                t.show();
            }
        });

        return rowView;
    }
}
