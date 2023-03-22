package com.example.esempio_scacchiera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView tentativiTv;
    ArrayList<Button> primaRiga;
    ArrayList<Button> secondaRiga;
    ArrayList<Button> terzaRiga;
    int tentativi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tentativi = 0;

        tentativiTv = findViewById(R.id.textView_tentativi);
        tentativiTv.setText("0");
        primaRiga = new ArrayList<>();
        secondaRiga = new ArrayList<>();
        terzaRiga = new ArrayList<>();


        for(int i = 1; i < 4; i++) {
            int ident = getResources().getIdentifier("num"+i, "id", getPackageName());
            Button bottone = (Button) findViewById(ident);
            primaRiga.add(bottone);
        }

        for(int i = 4; i < 7; i++) {
            int ident = getResources().getIdentifier("num"+i, "id", getPackageName());
            Button bottone = (Button) findViewById(ident);
            secondaRiga.add(bottone);
        }

        for(int i = 7; i < 10; i++) {
            int ident = getResources().getIdentifier("num"+i, "id", getPackageName());
            Button bottone = (Button) findViewById(ident);
            terzaRiga.add(bottone);
        }
    }

    public void upMove(View v) {
        String tagButton = v.getTag().toString();
        if (tagButton.equals("up1")) {
            String buff = terzaRiga.get(0).getText().toString();
            terzaRiga.get(0).setText(primaRiga.get(0).getText());
            String buffSecondaRiga = secondaRiga.get(0).getText().toString();
            secondaRiga.get(0).setText(buff);
            primaRiga.get(0).setText(buffSecondaRiga);
        }

        else if (tagButton.equals("up2")) {
            String buff = terzaRiga.get(1).getText().toString();
            terzaRiga.get(1).setText(primaRiga.get(1).getText());
            String buffSecondaRiga = secondaRiga.get(1).getText().toString();
            secondaRiga.get(1).setText(buff);
            primaRiga.get(1).setText(buffSecondaRiga);
        }

        else if (tagButton.equals("up3")) {
            String buff = terzaRiga.get(2).getText().toString();
            terzaRiga.get(2).setText(primaRiga.get(2).getText());
            String buffSecondaRiga = secondaRiga.get(2).getText().toString();
            secondaRiga.get(2).setText(buff);
            primaRiga.get(2).setText(buffSecondaRiga);
        }
        tentativi++;
        aggiornaTentativi();
        checkWin();
    }

    public void downMove(View v) {
        String tagButton = v.getTag().toString();
        if (tagButton.equals("down1")) {
            String buff = primaRiga.get(0).getText().toString();
            primaRiga.get(0).setText(terzaRiga.get(0).getText());
            String buffSecondaRiga = secondaRiga.get(0).getText().toString();
            secondaRiga.get(0).setText(buff);
            terzaRiga.get(0).setText(buffSecondaRiga);
        }

        else if (tagButton.equals("down2")) {
            String buff = primaRiga.get(1).getText().toString();
            primaRiga.get(1).setText(terzaRiga.get(1).getText());
            String buffSecondaRiga = secondaRiga.get(1).getText().toString();
            secondaRiga.get(1).setText(buff);
            terzaRiga.get(1).setText(buffSecondaRiga);
        }

        else if (tagButton.equals("down3")) {
            String buff = primaRiga.get(2).getText().toString();
            primaRiga.get(2).setText(terzaRiga.get(2).getText());
            String buffSecondaRiga = secondaRiga.get(2).getText().toString();
            secondaRiga.get(2).setText(buff);
            terzaRiga.get(2).setText(buffSecondaRiga);
        }
        tentativi++;
        aggiornaTentativi();
        checkWin();
    }

    public void leftMove(View v) {
        String tagButton = v.getTag().toString();
        if (tagButton.equals("left1")) {
            String buff = primaRiga.get(0).getText().toString();
            primaRiga.get(0).setText(primaRiga.get(1).getText());
            primaRiga.get(1).setText(primaRiga.get(2).getText());
            primaRiga.get(2).setText(buff);
        }

        else if (tagButton.equals("left2")) {
            String buff = secondaRiga.get(0).getText().toString();
            secondaRiga.get(0).setText(secondaRiga.get(1).getText());
            secondaRiga.get(1).setText(secondaRiga.get(2).getText());
            secondaRiga.get(2).setText(buff);
        }

        else if (tagButton.equals("left3")) {
            String buff = terzaRiga.get(0).getText().toString();
            terzaRiga.get(0).setText(terzaRiga.get(1).getText().toString());
            terzaRiga.get(1).setText(terzaRiga.get(2).getText().toString());
            terzaRiga.get(2).setText(buff);
        }
        tentativi++;
        aggiornaTentativi();
        checkWin();
    }

    public void rightMove(View v) {
        String tagButton = v.getTag().toString();
        if (tagButton.equals("right1")) {
            String buff = primaRiga.get(2).getText().toString();
            primaRiga.get(2).setText(primaRiga.get(1).getText());
            primaRiga.get(1).setText(primaRiga.get(0).getText());
            primaRiga.get(0).setText(buff);
        }

        else if (tagButton.equals("right2")) {
            String buff = secondaRiga.get(2).getText().toString();
            secondaRiga.get(2).setText(secondaRiga.get(1).getText());
            secondaRiga.get(1).setText(secondaRiga.get(0).getText());
            secondaRiga.get(0).setText(buff);
        }

        else if (tagButton.equals("right3")) {
            String buff = terzaRiga.get(2).getText().toString();
            terzaRiga.get(2).setText(terzaRiga.get(1).getText());
            terzaRiga.get(1).setText(terzaRiga.get(0).getText());
            terzaRiga.get(0).setText(buff);
        }

        tentativi++;
        aggiornaTentativi();
        checkWin();
    }

    public void checkWin() {
        ArrayList<Button> listaFinale = new ArrayList<>();
        listaFinale.addAll(primaRiga);
        listaFinale.addAll(secondaRiga);
        listaFinale.addAll(terzaRiga);

        for(int i = 0; i < listaFinale.size()-1; i++) {
            Button attuale = listaFinale.get(i);
            int actualValue = Integer.valueOf(attuale.getText().toString());
            Button next = listaFinale.get(i+1);
            int nextValue = Integer.valueOf(next.getText().toString());
            if(actualValue != (nextValue-1)) {
                return;
            }
        }

        Toast.makeText(this, "HAI VINTO", Toast.LENGTH_SHORT).show();
    }

    public void aggiornaTentativi() {
        this.tentativiTv.setText(String.valueOf(tentativi));
    }

}