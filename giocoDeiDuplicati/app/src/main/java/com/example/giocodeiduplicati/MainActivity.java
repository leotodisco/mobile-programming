package com.example.giocodeiduplicati;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    String bufferTag;
    boolean clicked;
    ArrayList<Button> btnList;
    Button bottone;
    int indovinati = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bufferTag = new String();
        btnList = new ArrayList<>();
        clicked = false;
        for(int i = 1; i < 5; i++) {
            /**Ottengo id di ogni bottone*/
            int buttonId = getResources().getIdentifier("button_" + i, "id", getPackageName());
            bottone = (Button) findViewById(buttonId);
            btnList.add(bottone);

        }
        btnList.stream().forEach(btn -> btn.setBackgroundColor(Color.BLUE));
    }

    public void mossa(@NonNull View v) throws InterruptedException {
        if (v.getTag().equals("YELLOW")) {
            v.setBackgroundColor(Color.YELLOW);
        }

        if (v.getTag().equals("RED")) {
            v.setBackgroundColor(Color.RED);
        }

        if (clicked == true) {
            if (v.getTag().toString().equals(bufferTag)) {
                indovinati++;
                checkWin();
                clicked = false;
            }
            else {
                //TimeUnit.SECONDS.sleep(25);

                v.setBackgroundColor(Color.BLUE);
            }
        } else {
            bufferTag = v.getTag().toString();
            clicked = true;
        }
    }

    public void checkWin() {
        if(indovinati == this.btnList.size()/2) {
            Toast.makeText(this, "VITTORIA", Toast.LENGTH_LONG).show();
        }
    }
}