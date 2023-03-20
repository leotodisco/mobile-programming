package com.example.campominato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
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
}