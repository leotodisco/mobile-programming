package com.example.campominato;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    GridLayout griglia;
    List<Button> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        griglia = (GridLayout) findViewById(R.id.griglia);
        lista = griglia.getTouchables().stream().map(b -> (Button) b).collect(Collectors.toList());

        generaCampo();
    }

    /**
     * SI CALCOLA LA DISTANZA DALLE BOMBE per ogni bottone
     */
    public void generaCampo() {
        piazzaBombe();
        for(Button b : lista) {
            int idx = lista.indexOf(b);
            int buff = 0;


            if(b.getTag().toString().equals("bomba")) {
                continue;
            }

            for(int i = 1; i <= 5; i++) {
                if(idx % 4 == 3){
                    if(i == 1 || i == 2 ||i == 5) {
                        continue;
                    }
                }

                if(idx % 4 == 0){
                    if( i == 2 || i == 3) {
                        continue;
                    }
                }

                if(idx % 4 == 2){
                    if( i == 2) {
                        continue;
                    }
                }

                if(idx % 4 == 1){
                    if( i == 2) {
                        continue;
                    }
                }

                if(i == 2) {
                    continue;
                }

                if((idx+i) >= lista.size()) {
                    continue;
                }

                if(lista.get(i+idx).getTag().toString().equals("bomba")){
                    buff++;
                }
            }

            if(idx <= 0){
                b.setTag(buff);
                continue;
            }


            for(int i = -1; i >= -5; i--){
                if((idx+i) < 0) {
                 continue;
                }

                if(idx % 4 == 0){
                    if(i == -1 || i == -2 || i == -5) {
                        continue;
                    }
                }

                if(idx % 4 == 1){
                    if( i == -2) {
                        continue;
                    }
                }

                if(idx % 4 == 2){
                    if( i == -2) {
                        continue;
                    }
                }

                if(idx % 4 == 3){
                    if(i == -2 || i == -3) {
                        continue;
                    }
                }

                if(lista.get(idx+i).getTag().toString().equals("bomba")){
                    buff++;
                }


            }
            b.setTag(buff);
        }
    }

    /**
     * piazza casualmente le bombe sul campo
     */
    public void piazzaBombe() {
        int i = 0;
        
        for(; i < 4; i++){
            Random ra = new Random();
            int interoGenerato = ra.ints(0, 15)
                                    .findFirst()
                                    .getAsInt();

            Button x = lista.get(interoGenerato);
            x.setTag("bomba");
        }

    }

    public void clicca(View v) {
        if(v.getTag().toString().equals("bomba")) {
            lista.forEach(b->b.setText(b.getTag().toString()));
            lista.forEach(b->b.setEnabled(false));
            Toast.makeText(getApplicationContext(), "Hai perso", Toast.LENGTH_LONG).show();
            return;
        }

        v = (Button) v;
        ((Button) v).setText(v.getTag().toString());
        return;
    }

    public void reset(View v) {
        lista.forEach(s -> s.setText(""));
        lista.forEach(s->s.setEnabled(true));
        generaCampo();
    }
}

