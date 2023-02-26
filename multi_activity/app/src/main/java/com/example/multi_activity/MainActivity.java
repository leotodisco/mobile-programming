package com.example.multi_activity;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Anche qui il metodo è chiamato dall' onClick() sul pulsante.
     * @param v
     */
    public void lanciaActivity(View v) {
        /**
         * Intent è la classe che permette di lanciare una nuova attività.
         * L'attuale activity normalmente viene posta al top dello stack delle activity.
         * Qui parliamo di intent esplicito.
         * this è il contesto.
         * Activity One è la prossima activity a cui si passa.
         */
        Intent i = new Intent(this, ActivityOne.class);
        /**
         * Il seguente flag fa sì che l'activity attuale non sia salvata nel Backstack
         * tuttavia, non può essere usata dalla mainActivity.
         *
         *      i.setFlags(i.getFlags() | FLAG_ACTIVITY_NO_HISTORY);
         */

        startActivity(i);
    }
}