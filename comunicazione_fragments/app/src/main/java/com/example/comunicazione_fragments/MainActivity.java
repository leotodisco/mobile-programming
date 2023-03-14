package com.example.comunicazione_fragments;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FrammentoA.ComunicazioneInterface {
    FragmentManager fm;
    FrameLayout f1, f2;
    FrammentoA buffer = new FrammentoA();
    FrammentoA buffer2 = new FrammentoA();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = findViewById(R.id.frame1);
        f2 = findViewById(R.id.frame2);

        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame1, buffer);
        ft.add(R.id.frame2, buffer2);
        ft.commit();
    }

    public void chiama(View v) {
        settaTesto("s");
    }

    @Override
    public void settaTesto(String s) {
        buffer.updateText("ao");
        buffer2.updateText("aoq");

    }
}