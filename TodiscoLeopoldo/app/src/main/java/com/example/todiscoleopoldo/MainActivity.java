package com.example.todiscoleopoldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * In questo metodo andiamo a mostrare all'utente ciò che lui desidera.
     * @param v la view da cui si avvia.
     */
    public void dispatch(View v) {
        if(v.getTag().equals("calcolaGiorni")) {
            i = new Intent(getApplicationContext(), CalcolaGiorni.class);
            startActivity(i);
        }

        else if(v.getTag().equals("sottraiGiorni")) {
            i = new Intent(getApplicationContext(), CalcolaDifferenza.class);
            startActivity(i);
        }
        else if(v.getTag().equals("sommaGiorni")) {
            i = new Intent(getApplicationContext(), CalcolaSomma.class);
            startActivity(i);
        }
    }



}