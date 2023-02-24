package com.example.list_view_complessa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Drawable i;
    private Contatto c1, c2, c3;
    private ListView lw;
    private CustomAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i  = getResources().getDrawable(R.drawable.ferrari);

        Contatto c1 = new Contatto("Leopoldo", i);
        Contatto c2 = new Contatto("Michele", i);
        Contatto c3 = new Contatto("Gianni", i);

        Contatto[] cList = {c1, c2, c3};

        lw = (ListView) findViewById(R.id.lista2);

        adapter = new CustomAdapter(this, R.id.lista2, Arrays.asList(cList));
        lw.setAdapter(adapter);
    }

    /**
     * quando si clicca sull'immagine.
     * nel file xml viene messo un onclick() sull'immagine.
     * @param v
     */
    public void onPictureClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = adapter.getItem(position);
        Toast.makeText(getApplicationContext(), "foto "+position+": " +c.getNome(), Toast.LENGTH_LONG)
                .show();
    }

    /**
     * quando si clicca sul testo.
     * Anche qui c'è un onclick().
     * @param v
     */
    public void onTextClick(View v) {
        int pos = Integer.parseInt(v.getTag().toString());
        Contatto c = adapter.getItem(pos);
        Toast.makeText(getApplicationContext(), "testo " + pos, Toast.LENGTH_LONG).show();
    }
}