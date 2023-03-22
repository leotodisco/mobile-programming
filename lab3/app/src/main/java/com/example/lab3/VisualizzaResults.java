package com.example.lab3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class VisualizzaResults extends Activity {
    SharedPreferences sp;
    TextView primo,secondo,terzo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        primo = (TextView) findViewById(R.id.primaPosizione);
        secondo = (TextView) findViewById(R.id.secondaPosizione);
        terzo = (TextView) findViewById(R.id.terzaPosizione);
        sp = getSharedPreferences("prefs", MODE_PRIVATE);

        primo.setText(String.valueOf(sp.getInt("primo", 0)));
        secondo.setText(String.valueOf(sp.getInt("secondo", 0)));
        terzo.setText(String.valueOf(sp.getInt("terzo", 0)));

    }

    public void tornaDietro(View v) {
        finish();
    }





}
