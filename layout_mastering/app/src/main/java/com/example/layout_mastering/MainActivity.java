package com.example.layout_mastering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lw;
    ArrayList<String> nomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        nomi = new ArrayList<>();
        nomi.add("peppe");
        nomi.add("mike");
        nomi.add("gianni");
        nomi.add("peppe");
        nomi.add("mike");
        nomi.add("gianni");

        lw = (ListView) findViewById(R.id.lista);
        /**
         * VUOLE SEMPRE IL LAYOUT DEL LIST_ELEMENT.
         */
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.list_element, nomi);

        lw.setAdapter(ad);

        lw.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "hai cliccato su " + position, Toast.LENGTH_SHORT).show();
                    }
                }
        );





    }
}