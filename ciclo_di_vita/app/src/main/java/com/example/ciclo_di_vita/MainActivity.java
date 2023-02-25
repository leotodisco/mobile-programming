package com.example.ciclo_di_vita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


/**
 * Il ciclo di vita delle app android è:
 * APP NON ESISTE:
 *  1.onCreate
 *  2.onStart
 *  3.onResume
 *
 * APP IN ESECUZIONE
 * 1.onPause
 * 2.onStop
 * 3.onDestroy()
 *
 * ATTIVITA NON ESISTE
 * 4.onRestart()
 *
 *
 * esiste il metodo finish che a sua volta chiama in modo corretto tutti
 * i metodi per chiudere l'app correttamente.
 * Quindi chiama onPause() poi onStop() poi onDestroy()
 */
public class MainActivity extends Activity {

    /**
     * Quando l'app non esiste si esegue prima il metodo onCreate.
     * Crea il layout.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
         // qui inizializzo le variabili
        }

        Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_LONG).show();
    }

    /**
     * è il secondo metodo che viene chiamato
     */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart chiamato", Toast.LENGTH_LONG).show();
    }

    /**
     * è il terzo metodo che viene chiamato
     */
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume chiamato", Toast.LENGTH_LONG).show();
    }

    /**
     * viene chiamato prima che l'attività smetta di esistere.
     * viene chiamato quando l'user preme il pulsante Home prima del metodo onStop().
     * Non causa perdita dello stato.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause chiamato", Toast.LENGTH_LONG).show();
    }

    /**
     * viene chiamato prima di onStart e di onResume quando l'user riavvia l'app dopo averla
     * messa onPause.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart chiamato", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop chiamato", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy chiamato", Toast.LENGTH_LONG).show();
    }

    /**
     * Quando l'utente ruota lo schermo l'app viene prima eliminata e poi ricreata,
     * quindi si perde ogni forma di stato.
     * Un modo di reagire è quello di fare override del metodo
     * onSaveInstanceState() e poi recuperare lo stato nella onCreate.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        /**QUI CI SONO DEGLI ESEMPI DI COME POTREI SALVARE LO STATO*/
        //savedInstanceState.putStringArrayList("LISTA_CHIAMATE", array);
        //savedInstanceState.putIntegerArrayList();
        //savedInstanceState.putInt();
        super.onSaveInstanceState(savedInstanceState);
    }

}