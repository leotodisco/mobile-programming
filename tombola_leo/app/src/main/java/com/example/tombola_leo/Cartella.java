package com.example.tombola_leo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class Cartella extends Fragment {
    int numeri[];

    /**
     * richiesto costruttore vuoto
     */
    public Cartella() {
    }

    public void setNumeri(int[] numeri) {
        this.numeri = numeri;
    }

    /**
     * Questo metodo va sempre implementato.
     * Si occupa di popolare la table nel frontend.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bello, container, false);
        ArrayList<View> tuttiBottoni;
        /**
         * trova tutti i bottoni nella table.
         */
        tuttiBottoni = (v.findViewById(R.id.cartellaTable)).getTouchables();
        int i = 0;

        for(View element:tuttiBottoni) {
            Button b = (Button) (element);
            if(b != null && numeri != null) {
                b.setText("" + numeri[i]);
                i++;
            }
        }

        return v;
    }
}
