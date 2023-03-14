package com.example.giocodeiduplicati;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String bufferTag;
    boolean clicked;
    ArrayList<Button> btnList;
    Button bottone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bufferTag = new String();
        btnList = new ArrayList<>();
        for(int i = 1; i < 5; i++) {
            /**Ottengo id di ogni bottone*/
            int buttonId = getResources().getIdentifier("button_" + i, "id", getPackageName());
            bottone = (Button) findViewById(buttonId);
            btnList.add(bottone);

        }
        btnList.stream().forEach(btn -> btn.setBackgroundColor(Color.BLUE));
    }

    public void mossa(View v) {
            if (v.getTag().equals("YELLOW"))
                v.setBackgroundColor(Color.YELLOW);

            if (v.getTag().equals("RED"))
                v.setBackgroundColor(Color.RED);

            if (clicked == true) {
                if (v.getTag().equals(bufferTag)) {
                    Toast.makeText(this, "WIN", Toast.LENGTH_LONG).show();
                    clicked = false;
                    btnList.stream().forEach(btn -> btn.setEnabled(false));
                }
                else {
                    btnList.stream().forEach(btn -> btn.setBackgroundColor(Color.BLUE));
                    this.bufferTag = new String();
                    clicked = false;
                }
            } else {
                bufferTag = v.getTag().toString();
                clicked = true;
            }
        }
}