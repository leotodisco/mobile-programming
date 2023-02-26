package com.example.threads;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.KeyguardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * esercizio per studiare i thread e come essi sono gestiti da android.
 * Android non permette a un thread che non sia il main di modificare la UI.
 * Quindi si può usare il metodo post delle view che all'interno vuole un runnable
 * oppure puoi usare il metodo runOnUiThread(Runnavle action) della classe Activity.
 * I thread sono quelli basic di Java, Il metodo start non fa altro che eseguire il metodo run,
 * che noi andremo a sovrascrivere.
 * Nota che i thread implementano l'interfaccia Runnable.
 */
public class MainActivity extends AppCompatActivity {
    Integer counter = 0;
    TextView valoreCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valoreCounter = (TextView) findViewById(R.id.contatore);
        valoreCounter.setText("s");


    }

    public void incrementa(View v) {
        this.counter++;
        valoreCounter.setText(String.valueOf(counter));

    }

    /**
     * metodo core dell'app in questione.
     * @param v bottone da cui si chiama il metodo.
     */
    public void clickNuovo(View v) {

        new Thread(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /** normalmente da un thread che non sia il main non puoi
             *  modificare la UI, per farlo ci sono due modi,
             *      uno è quello di usare il metodo post che all'interno vuole un runnable (Thread)
             *      uno è quello di usare il metodo MainActivity.this.runOnUiThread(new Runnable()) e override del run().
             *
             * */
            valoreCounter.post(new Thread(() -> {
                valoreCounter.setText("9000");
            }));
        }).start();
    }


}