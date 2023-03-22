package com.example.lab5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView l1, l2;
    ArrayAdapter<String> arr, arr2;
    ArrayList<String> nomiList, nomiList2;
    Switch s;
    String buff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buff = new String();
        s = (Switch) findViewById(R.id.selezionatore);

        l1 = (ListView) findViewById(R.id.lista1);
        l2 = (ListView) findViewById(R.id.lista2);

        nomiList = new ArrayList<String>();
        nomiList.add("Nicola");
        nomiList.add("Mario");


        nomiList2 = new ArrayList<String>();
        nomiList2.add("Nicola");
        nomiList2.add("Mario");
        nomiList2.add("Gianni");

        arr = new ArrayAdapter<>(this, R.layout.list_element, nomiList);
        arr2 = new ArrayAdapter<>(this, R.layout.list_element, nomiList2);

        l1.setAdapter(arr);
        l2.setAdapter(arr2);

        l1.setOnItemClickListener((parent, view, position, id) -> {
            if(!s.isChecked()) {
                String obj = arr.getItem(position);
                arr.remove(obj);
            } else {
                String obj = arr.getItem(position);
                arr.remove(obj);
                arr2.add(obj);
            }
        });

        l2.setOnItemClickListener((parent, view, position, id) -> {
            if(!s.isChecked()) {
                String obj = arr2.getItem(position);
                arr2.remove(obj);
            } else {
                String obj = arr2.getItem(position);
                arr2.remove(obj);
                arr.add(obj);
            }
        });

    }

    public void insertButton(View v) {
        /**
         * si setta il flag che mi indica in quale delle due liste devo aggiungere l'elemento
         */
        buff = v.getTag().toString();
        Intent i = new Intent(getApplicationContext(), ReaderActivity.class);
        startActivityForResult(i, 0);

        return;
    }

    /**
     * metodo che si occupa di elaborare il risultato della nuova activity.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String returnString = data.getStringExtra("result");

        if(this.buff.equals("inserisci1")) {
            insertToList(arr, returnString);
        } else if(this.buff.equals("inserisci2")) {
            insertToList(arr2, returnString);
        }
    }

    public void insertToList(ArrayAdapter<String> arrayAdapter, String nome) {
        arrayAdapter.add(nome);
    }
}