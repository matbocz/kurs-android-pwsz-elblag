package com.example.listy4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PainterAdapter extends ArrayAdapter<Painter> {
    Context context;
    List<Painter> painters;

    public PainterAdapter(@NonNull Context context, @NonNull List<Painter> objects) {
        super(context, R.layout.painters_list, objects);
        this.context = context;
        painters = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.painters_list, parent, false);

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        nameTextView.setText(painters.get(position).getName());

        ImageView pictureImageView = view.findViewById(R.id.pictureImageView);
        pictureImageView.setImageResource(painters.get(position).getPicture());

        final CheckBox deleteCheckBox = view.findViewById(R.id.deleteCheckBox);
        deleteCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteCheckBox.isChecked())
                    painters.get(position).toDelete = true;
                else
                    painters.get(position).toDelete = false;
            }
        });

        return view;
    }
}
