package com.example.listy3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FlagAdapter extends ArrayAdapter<Flag> {
    Context context;
    List<Flag> flags;

    public FlagAdapter(@NonNull Context context, @NonNull List<Flag> objects) {
        super(context, R.layout.list_element, objects);
        this.context = context;
        flags = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View widok = inflater.inflate(R.layout.list_element, parent, false);

        TextView flagTextView = widok.findViewById(R.id.flagName);
        ImageView flagImageView = widok.findViewById(R.id.flagImage);

        flagTextView.setText(flags.get(position).getName());
        flagImageView.setImageResource(flags.get(position).getPicture());

        return widok;
    }
}
