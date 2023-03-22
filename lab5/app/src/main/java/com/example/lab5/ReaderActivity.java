package com.example.lab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Questa activity deve solamente leggere il valore
 * che l'utente inserisce.
 */
public class ReaderActivity extends Activity {
    String result;
    EditText et;
    Button insert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader);

        et = (EditText) findViewById(R.id.etInserisci);
        insert = (Button) findViewById(R.id.inserisciButton);

    }

    public void inserisci(View v) {
        Intent i = new Intent();
        result = et.getText().toString();

        i.putExtra("result", result);
        setResult(RESULT_OK, i);
        finish();
    }
}
