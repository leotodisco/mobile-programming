package com.example.todiscoleopoldo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcolaGiorni extends Activity {
    DatePicker d1, d2;
    TextView giorniTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcola_giorni);

        giorniTV = (TextView) findViewById(R.id.risultatoTV);
        d1 = (DatePicker) findViewById(R.id.primaData);
        d2 = (DatePicker) findViewById(R.id.secondaData);
    }

    /**
     * Metodo in cui si effettua il calcolo dei giorni fra due date
     * @return
     */
    public void calcolaGiorni(View v) {
        LocalDate data1 = LocalDate.of(d1.getYear(), d1.getMonth(), d1.getDayOfMonth());
        LocalDate data2 = LocalDate.of(d2.getYear(), d2.getMonth(), d2.getDayOfMonth());

        long nGiorni = ChronoUnit.DAYS.between(data1, data2);
        this.giorniTV.setText("Giorni di differenza: " + String.valueOf(nGiorni));
    }
}
