package com.example.prova4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Una miglioria stava nel fare un metodo clickSuNome()
 * e nel clickSuNome() si controlla se si vuole spostare o eliminare.
 */
public class MainActivity extends AppCompatActivity {
    Boolean cancella;
    Boolean sposta;
    Switch s;

    ArrayAdapter<String> adapterDx;
    ArrayAdapter<String> adapterSx;
    ListView leftOne;
    ListView rightOne;
    List<String> nomiSx;
    List<String> nomiDx;

    List<String> tuttiNomi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sposta = true;
        cancella = false;

        tuttiNomi = List.of("Carlo", "Angelo", "Alessio","Giuseppe", "Giovanni", "Davide", "Nicola", "Grazia", "Gianni" );

        leftOne = (ListView) findViewById(R.id.lista_sx);
        rightOne = (ListView) findViewById(R.id.lista_dx);


        nomiDx = new ArrayList<>();
        nomiSx = new ArrayList<>();
        adapterSx = new ArrayAdapter<String>(this, R.layout.list_element, (nomiSx));
        adapterDx = new ArrayAdapter<String>(this, R.layout.list_element, (nomiDx));

        leftOne.setAdapter(adapterSx);
        rightOne.setAdapter(adapterDx);
        s = (Switch) findViewById(R.id.decisione);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(s.isChecked()) {
                     cancella = true;
                     sposta = false;
                 } else {
                     sposta = true;
                     cancella = false;
                 }
             }
         });

        rightOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(cancella) {
                    adapterDx.remove(adapterDx.getItem(position));
                    adapterDx.notifyDataSetChanged();
                }
                else if(sposta) {
                    String itm = adapterDx.getItem(position);
                    adapterDx.remove(itm);
                    adapterSx.add(itm);
                    adapterDx.notifyDataSetChanged();
                    adapterSx.notifyDataSetChanged();
                }
            }
        });

        leftOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(cancella) {
                    adapterSx.remove(adapterSx.getItem(position));
                    adapterSx.notifyDataSetChanged();
                }
                else if(sposta) {
                    String itm = adapterSx.getItem(position);
                    adapterSx.remove(itm);
                    adapterDx.add(itm);
                    adapterDx.notifyDataSetChanged();
                    adapterSx.notifyDataSetChanged();
                }
            }
        });
    }


    public void popola(View v) {
        if(v.getTag().equals("lista_dx")) {
            adapterDx.addAll(tuttiNomi.subList(3, 5));
            adapterDx.notifyDataSetChanged();
        } else {
            adapterSx.addAll(tuttiNomi.subList(0, 3));
            adapterSx.notifyDataSetChanged();
        }
    }


}