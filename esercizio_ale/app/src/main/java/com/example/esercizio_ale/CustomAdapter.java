package com.example.esercizio_ale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {
    private LayoutInflater inflater;

    public CustomAdapter(@NonNull Context context,
                         int resource,
                         @NonNull List<Contatto> objects) {
        super(context, resource,objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View oldView,
                        @NonNull ViewGroup parent) {

        if(oldView == null) {
            oldView = inflater.inflate(R.layout.single_element, null);
        }

        TextView nomeView;
        TextView numeroView;
        Button deleteButton;

        nomeView = (TextView) oldView.findViewById(R.id.nome);
        numeroView = (TextView) oldView.findViewById(R.id.numero);
        deleteButton = (Button) oldView.findViewById(R.id.delete);

        nomeView.setText(getItem(position).nome);
        numeroView.setText(getItem(position).numero);

        deleteButton.setTag(position);
        numeroView.setTag(position);
        nomeView.setTag(position);

        return oldView;
    }
}
