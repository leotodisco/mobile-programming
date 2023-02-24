package com.example.list_view_complessa;

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


public class CustomAdapter extends ArrayAdapter<Contatto> {
    /**Inflater permette di creaere oggetti view a partire da oggetti JAVA*/
    private LayoutInflater inflater;

    /**
     * Costruttore di un custom adapter.
     * @param context -> per il caller è this
     * @param resourceId -> id della listview
     * @param objects -> lista di oggetti java
     */
    public CustomAdapter(Context context, int resourceId, List<Contatto> objects) {
        super(context, resourceId, objects);
        /**inflater consente di creare oggetti di layout a partire da java objects
         * in questo caso viene iniettato dal Context*/
        inflater = LayoutInflater.from(context);
    }

    /**
     * @param position iesima posizione dell'elemento in questione.
     * @param convertView la vecchia view da riusare potrebbe essere null
     * @param parent listview
     * @return singola view adattata.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /** se la view è null non può essere riusata, quindi noi la creiamo grazie all'inflater*/
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.element, null);
        }

        Contatto c = getItem(position);

        /**In cui ci metto il nome*/
        TextView textView;
        /**In cui appare l'immagine finale*/
        ImageView imageView;

        /**Ottiene le view a partire dalla view esterna*/
        textView = convertView.findViewById(R.id.nome_elemento);
        imageView = convertView.findViewById(R.id.immagine);

        imageView.setImageDrawable(c.getImage());
        textView.setText(c.getNome());

        textView.setTag(position);
        imageView.setTag(position);

        return convertView;
    }
}






















