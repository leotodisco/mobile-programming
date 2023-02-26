package com.example.multi_activity;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Activity base
 * Ogni activity deve essere indicata nel file AndroidManifest.xml
 */
public class ActivityOne extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }


    /**
     * il metodo può essere lo stesso di altre activity, ma il comportamento è diverso.
     * Per leggibilità meglio evitare di dare sempre stessi nomi, magari danne uno esplicativo.
     * @param v
     */
    public void lanciaActivity(View v) {
        Intent i = new Intent(this, ActivityTwo.class);
        i.setFlags(i.getFlags() | FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
    }
}
