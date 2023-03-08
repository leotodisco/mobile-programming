package com.example.doppiotris;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    int turno; //1 = O, 0 = X
    Tris t1, t2;
    FragmentManager manager;
    FrameLayout frameLayout1;
    FrameLayout frameLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout1 = findViewById(R.id.tris1);
        //frameLayout2 = findViewById(R.id.tris2);
        t1 = new Tris();
        t2 = new Tris();
        settaFrammenti();
        turno = 0;

    }

    public void mossa(View v) {
        Button btn = (Button) v;
        // turno O -> t1
        if(turno == 1) {
            /**
             * metodo onClick consente di scrivere sul bottone
             */
            t1.onClick(v, turno);
            /**
             * si scrive sul corrispondente bottone nell'altro campo.
             */
            t1.getButtonByIndex(Integer.valueOf(v.getTag().toString()) - 1).setText("X");
            turno = 0;
            /**
             * SI DISATTIVANO E SI ATTIVANO I BOTTONI DI UN CAMPO O DELL'ALTRO.
             */
            t2.allButtons.stream().map(s->(Button) s).forEach(s->s.setEnabled(false));
            t1.allButtons.stream().map(s->(Button) s).forEach(s->s.setEnabled(true));

            if(t1.checkVittoria()) {
                Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            };
        }
        else if(turno == 0) {
            /**
             * metodo onClick consente di scrivere sul bottone
             */
            t2.onClick(v, turno);
            /**
             * si scrive sul corrispondente bottone nell'altro campo.
             */
            t2.getButtonByIndex(Integer.valueOf(v.getTag().toString()) - 1).setText("O");
            turno = 1;
            /**
             * SI DISATTIVANO E SI ATTIVANO I BOTTONI DI UN CAMPO O DELL'ALTRO.
             */
            t1.allButtons.stream().map(s->(Button) s).forEach(s->s.setEnabled(false));
            t2.allButtons.stream().map(s->(Button) s).forEach(s->s.setEnabled(true));

            if(t2.checkVittoria()) {
                Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            };
        }

        return;
    }

    public void settaFrammenti() {
        manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.tris1, t1);
        ft.add(R.id.tris2, t2);
        ft.commit();
        return;
    }



}