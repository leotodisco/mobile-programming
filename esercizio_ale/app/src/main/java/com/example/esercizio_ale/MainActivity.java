package com.example.esercizio_ale;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lw;
    Contatto a, b, c;
    Contatto newContatto;
    EditText nome, numero;
    ArrayList<Contatto> ctList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw = (ListView) findViewById(R.id.elenco_contatti);
        nome = (EditText) findViewById(R.id.nome_editText);
        numero = (EditText) findViewById(R.id.numero_editText);

        if(savedInstanceState != null) {
            ctList = savedInstanceState.getSerializable("list", ArrayList.class);
        } else {
            ctList = new ArrayList<>();
            a = new Contatto("Leopoldo", "124");
            b = new Contatto("Leopoldo", "381");
            c = new Contatto("Leopoldo", "380");
            ctList.add(a);
            ctList.add(b);
            ctList.add(c);
        }

        adapter = new CustomAdapter(this, R.id.elenco_contatti, ctList);
        lw.setAdapter(adapter);

    }

    /**
     * viene chiamato quando il bottone di aggiumta è chiamato
     * @param v è il bottone di aggiunta
     */
    public void readContatto(View v) {
        newContatto = new Contatto(nome.getText().toString(), numero.getText().toString());
        nome.setText(" ");
        nome.setHint("Aggiungi nome");
        numero.setText(" ");
        nome.setHint("Aggiungi numero");
        adapter.add(newContatto);
        adapter.notifyDataSetChanged();

        /**questa è un'alternativa:
         *
         *
         ctList.add(newContatto);
         adapter.notifyDataSetChanged();

         */
    }

    /**
     * permette di eliminare un oggetto dalla lista quando si clicca
     * sul tatso delete presente nella riga corrisposndente.
     * Viene richiamato siccome nella view c'è un onclick.
     * @param v è il bottone
     * A ogni bottone viene assegnato un tag che è la posizione,
     * in questo modo posso poi eliminare l'elemento grazie alla posizione.
     */
    public void onDeleteClick(View v) {
        int pos = Integer.parseInt(v.getTag().toString());
        Contatto x = adapter.getItem(pos);
        adapter.remove(x);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        /**QUI CI SONO DEGLI ESEMPI DI COME POTREI SALVARE LO STATO*/
        //savedInstanceState.putStringArrayList("LISTA_CHIAMATE", array);
        //savedInstanceState.putIntegerArrayList();
        //savedInstanceState.putInt();

        savedInstanceState.putSerializable("list", ctList);

        super.onSaveInstanceState(savedInstanceState);
    }




}