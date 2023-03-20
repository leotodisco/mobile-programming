package com.example.laboratorio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Ogni elemento ha 3 campi da gestire separatamente (lista customizzata), un campo ”Titolo”,
 * un campo “Autore” e un campo “Copertina”.
 * L’utente può inserire nuovi elementi tramite l’utilizzo di 2 EditText,
 * nei quali può specificare nuovi valori, ed un pulsante “Inserisci” che inserisce un nuovo elemento utilizzando
 * i valori degli EditText (per la Copertina si utilizzi una sola immagine per tutti – quindi è fissa e non va specificata).
 * L’interfaccia utente visualizza gli EditText,
 * il pulsante e anche la lista dei libri (il disegno riporta un riferimento solo indicativo).
 * Quando si clicca un elemento della lista l’elemento verrà cancellato dalla lista.
 * Miglioramento 1. Chiedere conferma della cancellazione tramite un dialog box.\
 * Miglioramento 2: Non perdere lo stato nelle rotazioni.
 */
public class MainActivity extends Activity {
    ListView lw;
    EditText titoloLibro;
    EditText nomeAutore;
    CustomAdapter ad;
    ArrayList<Libro> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();
        titoloLibro = (EditText) findViewById(R.id.titoloEditText);
        nomeAutore = (EditText) findViewById(R.id.nomeAutoreEditText);

        if(savedInstanceState != null) {
            lista = savedInstanceState.getSerializable("lista", ArrayList.class);
            titoloLibro.setText(savedInstanceState.getString("edit_titolo"));
        }
        lw = (ListView) findViewById(R.id.lista);
        ad = new CustomAdapter(getApplicationContext(), R.id.lista, lista);
        lw.setAdapter(ad);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                ad.remove(ad.getItem(position));
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Vuoi eliminare?");
                //dialogClickListener è l'onClickListener definito prima
                builder.setPositiveButton("Si", dialogClickListener);
                builder.setNegativeButton("No", dialogClickListener);
                builder.show();

            }
        });
        return;
    }

    public void inserisciButton(View v) {
        if(titoloLibro.getText().toString().isBlank()
            ||
            nomeAutore.getText().toString().isBlank()) {
            Toast.makeText(this, "devi inserire qualcosa.", Toast.LENGTH_SHORT).show();
            return;
        }

        String titolo = titoloLibro.getText().toString();
        String autore = nomeAutore.getText().toString();
        Libro l = new Libro(titolo, autore);
        ad.add(l);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable("lista", lista);
        outState.putString("edit_titolo", titoloLibro.getText().toString());
    }
}