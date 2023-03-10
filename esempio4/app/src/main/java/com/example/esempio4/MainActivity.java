package com.example.esempio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String parola = "casupola";
    int tentativi;
    TextView mainTV;
    TextView tentativiView;
    EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTV = (TextView) findViewById(R.id.text_view);
        et = (EditText) findViewById(R.id.edit_text);
        tentativiView = (TextView) findViewById(R.id.n_tentativi);

        generaCampoGioco();
        tentativi = 0;
    }

    /**
     * in questo metodo per ogni carattere della parola si mette un trattino.
     */
    public void generaCampoGioco() {
        StringBuffer trattini = new StringBuffer();
        for(int i = 0; i < parola.length(); i++) {
            trattini.append("_");
        }
        mainTV.setText(trattini.toString());
    }

    /**
     * metodo che viene chiamato quando si clicca su "prova"
     * @param v
     */
    public void faiTentativo(View v) {
        if(et.getText() == null || et.getText().toString().isEmpty() || et.getText().toString().length()>1) {
            return;
        }
        tentativi++;
        tentativiView.setText(String.valueOf(tentativi));

        char ch = et.getText().charAt(0);

        for(int i = 0; i < parola.length(); i++) {
            if(parola.charAt(i) == ch) {
                String buff = mainTV.getText().toString();
                char[] arr = buff.toCharArray();
                arr[i] = ch;
                mainTV.setText(String.valueOf(arr));

                checkWin();
            }
        }

        et.setText("");
    }

    public void checkWin() {
        if(mainTV.getText().equals(parola)) {
            Toast.makeText(this, "VITTORIA", Toast.LENGTH_SHORT).show();
            et.setEnabled(false);


        }
    }

}