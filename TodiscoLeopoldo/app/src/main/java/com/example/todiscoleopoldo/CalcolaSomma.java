package com.example.todiscoleopoldo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.time.LocalDate;

public class CalcolaSomma extends Activity {
    DatePicker d1;
    TextView giorniTV;
    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.somma);

        giorniTV = (TextView) findViewById(R.id.risultatoTV);
        d1 = (DatePicker) findViewById(R.id.primaData);
        et = (EditText) findViewById(R.id.giorniET);

    }

    /**
     * Metodo in cui eseguiamo la somma dei giorni alla data
     * @param v
     */
    public void calcola(View v) {
        if(et.getText() == null || et.getText().toString().isBlank()) {
            Toast.makeText(getApplicationContext(), "Devi inserire i giorni", Toast.LENGTH_SHORT).show();
            return;
        }
        /**Il mese va da 0 a 11 nel datePicker, dunque viene incrementato di 1*/
        LocalDate data1 = LocalDate.of(d1.getYear(), d1.getMonth()+1, d1.getDayOfMonth());
        LocalDate data2 = data1.plusDays(Integer.valueOf(et.getText().toString()));

        giorniTV.setText("Data = " + data2.toString());

    }
}
