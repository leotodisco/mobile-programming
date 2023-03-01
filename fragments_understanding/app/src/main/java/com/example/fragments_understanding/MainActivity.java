package com.example.fragments_understanding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        fragmentManager = getFragmentManager();

        FrammentoAQ frammento = new FrammentoAQ();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.contenitore, frammento,"tagFrammentoA");
        ft.commit();


    }



}