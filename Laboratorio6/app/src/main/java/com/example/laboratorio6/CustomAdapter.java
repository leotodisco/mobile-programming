package com.example.laboratorio6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Libro> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context,
                         int resourceId,
                         List<Libro> objects) {
        super(context, resourceId, objects);

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.elemento, null);
        }

        TextView titoloTV = (TextView) convertView.findViewById(R.id.titoloLibro1);
        TextView nomeAutoreTV = (TextView) convertView.findViewById(R.id.nomeAutore1);

        Libro l = getItem(position);

        titoloTV.setText(l.getTitolo());
        nomeAutoreTV.setText(l.getAutore());

        return convertView;
    }
}
