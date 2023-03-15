package it.unisa.mp.systembcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;
    TextView tv;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBroadcastReceiver();
        tv = (TextView) findViewById(R.id.textView);
        Log.d("DEBUG","on create");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**Si disinscrive il broadcastReceiver*/
        unregisterReceiver(receiver);
    }

    /**
     * Metodo in cui si registra un broadcast receiver
     * e il broadcast si inizializza creando un oggetto BroadcastReceiver che al suo interno
     * fa override del metodo onReceive in cui c'è la logica di reazione a un evento.
     */
    private void setBroadcastReceiver() {
        /**L'uso degli "Intent" consente all'applicazione di registrarsi per determinati messaggi
         * di broadcast e di rispondere di conseguenza.*/
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("DEBUG","Hello, another minute is gone!!!");
                counter++;
                String min = "minuti";
                if (counter == 1) min = "minuto";
                tv.setText(counter+" "+min);
            }
        };

        registerReceiver(receiver, intentFilter);
    }
}