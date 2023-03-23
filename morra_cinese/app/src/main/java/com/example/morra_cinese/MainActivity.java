package com.example.morra_cinese;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Morra cinese
 */
public class MainActivity extends AppCompatActivity {
    TextView npcTV;
    LinearLayout layout_scelte;
    List<String> scelteText;
    String sceltaGocatore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npcTV = (TextView) findViewById(R.id.scelta_npc);
        layout_scelte = (LinearLayout) findViewById(R.id.container_scelte);
        scelteText = new ArrayList<>();
        scelteText.add("forbici");
        scelteText.add("carta");
        scelteText.add("sasso");

        sceltaGocatore = new String();

    }

    public void aggiornaUi(View v) {
        layout_scelte.setVisibility(View.VISIBLE);
    }

    public void mossa(View v) {
        this.sceltaGocatore = v.getTag().toString();
        Random ra = new Random();
        int interoGenerato = ra.ints(0, 2)
                .findFirst()
                .getAsInt();

        String pcChoice = this.scelteText.get(interoGenerato);
        this.npcTV.setText(pcChoice.toUpperCase());
        checkWin(pcChoice);
    }


    public void checkWin(String sceltaPc) {
        if(this.sceltaGocatore.equals(sceltaPc)) {
            Toast.makeText(this, "Pareggio", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(sceltaGocatore.equals("forbici")) {
            if(sceltaPc.equals("carta")) {
                Toast.makeText(this, "Vittoria", Toast.LENGTH_SHORT).show();
            }
            else if(sceltaPc.equals("sasso")) {
                Toast.makeText(this, "Sconfitta", Toast.LENGTH_SHORT).show();
            }
        }

        else if(sceltaGocatore.equals("carta")) {
            if(sceltaPc.equals("sasso")) {
                Toast.makeText(this, "Vittoria", Toast.LENGTH_SHORT).show();
            }
            else if(sceltaPc.equals("forbici")) {
                Toast.makeText(this, "Sconfitta", Toast.LENGTH_SHORT).show();
            }
        }

        else if(sceltaGocatore.equals("sasso")) {
            if(sceltaPc.equals("forbici")) {
                Toast.makeText(this, "Vittoria", Toast.LENGTH_SHORT).show();
            }
            else if(sceltaPc.equals("carta")) {
                Toast.makeText(this, "Sconfitta", Toast.LENGTH_SHORT).show();
            }
        }



    }
}