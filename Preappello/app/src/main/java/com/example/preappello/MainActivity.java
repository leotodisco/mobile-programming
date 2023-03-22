package com.example.preappello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    GridLayout grid;
    Switch aSwitch;
    ArrayList<Button> allButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridLayout) findViewById(R.id.griglia);
        aSwitch = (Switch) findViewById(R.id.selezionatore);
        allButton = (ArrayList<Button>) grid.getTouchables()
                .stream()
                .map(el -> (Button) el).collect(Collectors.toList());
    }

    public void mossa(View v) {
        if(aSwitch.isChecked()) {
            //incremento colonna
            final String identificatore = String.valueOf(v.getTag().toString().charAt(1));
            List<Button> toIncrement = allButton.stream().filter(el -> el.getTag().toString().endsWith(identificatore)).collect(Collectors.toList());
            toIncrement.forEach(el -> el.setText(String.valueOf(Integer.valueOf(el.getText().toString())+1)));
        } else {
            //incremento riga
            final String identificatore = String.valueOf(v.getTag().toString().charAt(0));
            List<Button> toIncrement = allButton.stream().filter(el -> el.getTag().toString().startsWith(identificatore)).collect(Collectors.toList());
            toIncrement.forEach(el -> el.setText(String.valueOf(Integer.valueOf(el.getText().toString())+1)));
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Lo schermo è in modalità landscape
            allButton.forEach(el -> el.setText(String.valueOf(Integer.valueOf(el.getText().toString())+1)));
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Lo schermo è in modalità portrait
            allButton.forEach(el -> el.setText(String.valueOf(Integer.valueOf(el.getText().toString())+1)));
        }
    }
}