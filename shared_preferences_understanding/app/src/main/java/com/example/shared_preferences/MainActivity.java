package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * app che permette di incrementare un contatore,
 * i valori più alti vengono salvati tramite SharedPreferences.
 */
public class MainActivity extends AppCompatActivity {
    TextView personaTV;
    TextView valoreTV;
    TextView actual_value;
    Button decrementaButton;
    Button incrementaButton;
    Button endButton;
    int counter;

    /**
     * sono dati che vogliamo condividere nel formato key-value.
     */
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personaTV = findViewById(R.id.nomeRecord1);
        valoreTV = (TextView) findViewById(R.id.valoreRecord1);
        actual_value = findViewById(R.id.valore_attuale);
        decrementaButton = (Button) findViewById(R.id.decrementa);
        incrementaButton = (Button) findViewById(R.id.incrementa);
        endButton = (Button) findViewById(R.id.fine);
        counter = 0;

        //getSharedPreferences per condividere con altre activity della stessa app
        // si può specificare il nome di un file per avere diversi "database"
        sp = getSharedPreferences("File",MODE_PRIVATE);

    }

    /**
     * Questo metodo viene chiamato dopo che si esce dall'activity dell'intent.
     * In altre parole qua dentro chiamiamo updateNames(),
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        updateNames();
    }

    /**
     * Metodo che aggiorna il valore record della textview.
     */
    private void updateNames() {
        //Update del punteggio nel caso sia stato salvato
        //Se abbiamo salvato il punteggio lo recuperiamo
        counter = sp.getInt("HIGHSCORE1",0);
        valoreTV.setText(String.valueOf(counter));
    }

    public void incrementa(View v) {
        String val = actual_value.getText().toString();
        Integer intero = Integer.parseInt(val);
        intero++;
        counter = intero;
        actual_value.setText(intero.toString());
    }

    public void decrementa(View v) {
        String val = actual_value.getText().toString();
        Integer intero = Integer.parseInt(val);
        if(intero == 0) {
            return;
        }
        intero--;
        counter = intero;
        actual_value.setText(intero.toString());
    }

    /**
     * se alla fine della partita il valore acquisito è maggiore del
     * valore record, allora si lancia una nuova activity in cui salviamo il valore record.
     * @param v pulsante con onclick.
     */
    public void end(View v) {
        String val = valoreTV.getText().toString();
        Integer intero = Integer.parseInt(val);

        if(counter > intero) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), HighScore.class);
            i.putExtra("PUNTEGGIO",counter);
            startActivity(i);
        }

        actual_value.setText(String.valueOf(0));
    }






}