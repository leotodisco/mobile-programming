package com.example.shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighScore extends Activity {
    TextView personaTV;
    TextView valoreTV;
    SharedPreferences prefs;
    int punteggio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_score);

        personaTV = findViewById(R.id.record_nome);
        valoreTV = findViewById(R.id.record_valore);

        /**
         * andiamo a prendere il punteggio che abbiamo passato
         * a questa activity.
         */
        punteggio = getIntent().getIntExtra("PUNTEGGIO", -1);
        //getSharedPreferences per condividere con altre activity della stessa app
        // si può specificare il nome di un file per avere diversi "database"
        prefs = getSharedPreferences("File",MODE_PRIVATE);

    }

    public void inserisciNome(View v) {
        /**
         * editor è una interfaccia per modificare i valori in uno
         * shared preference.
         */
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("HIGHSCORE1", punteggio);
        editor.putString("RECORDMAN3", "PEPPINO");
        editor.putInt("SCORE",0);
        editor.commit();
        /**
         * chiudiamo questa activity.
         */
        finish();
    }



}
