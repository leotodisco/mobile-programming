package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

/**
 * videogame
 */
public class MainActivity extends AppCompatActivity {
    int counter;
    TextView tv_counter;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        tv_counter = (TextView) findViewById(R.id.contatore_value);

        sp = getSharedPreferences("prefs", MODE_PRIVATE);


    }

    public void incrementa(View v) {
        counter++;
        tv_counter.setText(String.valueOf(counter));


    }

    public void decrementa(View v) {
        if(counter == 0) {
            return;
        }
        counter--;
        tv_counter.setText(String.valueOf(counter));
    }

    public void vediRecord(View v){
        Intent i = new Intent(getApplicationContext(), VisualizzaResults.class);
        startActivity(i);
    }

    public void end(View v) {
        int primo = sp.getInt("primaPosizione", 0);
        int secondo = sp.getInt("secondaPosizione", 0);
        int terzo = sp.getInt("terzaPosizione", 0);
        SharedPreferences.Editor editor = sp.edit();
        if(counter >= primo){
            if(editor == null) {
                finish();
            }
            Toast.makeText(this, "maggiore del primo", Toast.LENGTH_SHORT).show();
            // modifica primo con value, secondo con primo e terzo con secondo
            editor.putInt("primo", counter);
            editor.putInt("secondo", primo);
            editor.putInt("terzo", secondo);
            editor.commit();
        }else if(counter >= secondo){
            Toast.makeText(this, "maggiore del secondo", Toast.LENGTH_SHORT).show();
            // modifica secondo diventa terzo e value diventa secondo
            editor.putInt("secondo", counter);
            editor.putInt("terzo", secondo);
            editor.apply();
        }else if(counter > terzo){
            Toast.makeText(this, "maggiore del terzo", Toast.LENGTH_SHORT).show();
            // modifica solo terzo
            editor.putInt("terzo", counter);
            editor.apply();
        }

        editor.commit();
    }

    public void reset(View v) {
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.commit();
    }

}