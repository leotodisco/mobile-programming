package com.example.doppiotris;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Tris extends Fragment {
    ArrayList<View> allButtons;

    public Tris() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment, container, false);
        allButtons = (v.findViewById(R.id.campoGioco)).getTouchables();
        return v;
    }

    public void setAllButtons(ArrayList<View> allButtons) {
        this.allButtons = allButtons;
    }

    public ArrayList<View> getAllButtons() {
        return allButtons;
    }

    public void onClick(View view, int turno) {
        Button btn = (Button) view;
        if(btn.getText().toString().equals("")){
            if(turno == 0) {
                btn.setText("O");
            }
            else {
                btn.setText("X");
            }
        }
    }

    public Button getButtonByIndex(int index){
        return (Button)allButtons.get(index);
    }

    public boolean checkVittoria() {

        /**
         * CONTROLLO RIGHE
         */
        for(int i = 1; i < 7; i=i+3) {
            if(getButtonByIndex(i-1).getText().equals("")){
                continue;
            }
            if (getButtonByIndex(i-1).getText().equals(getButtonByIndex(i).getText())
                    && getButtonByIndex(i).getText().equals(getButtonByIndex(i+1).getText())) {
                return true;
            }
        }

        /**CONTROLLO COLONNE*/
        for(int i = 1; i < 4; i++) {
            if(getButtonByIndex(i-1).getText().equals("")){
                continue;
            }
            if (getButtonByIndex(i-1).getText().equals(getButtonByIndex(i+2).getText())
                    && getButtonByIndex(i+2).getText().equals(getButtonByIndex(i+5).getText())) {
                return true;
            }
        }

        /**CONTROLLO DIAGONALE SX*/
        for(int i = 1; i < 6; i=i+3) {
            System.out.println(" i vale "+ i);
            if(getButtonByIndex(i-1).getText().equals("")){
                continue;
            }

            if (getButtonByIndex(i-1).getText().equals(getButtonByIndex(i+3).getText())
                    && getButtonByIndex(i+3).getText().equals(getButtonByIndex(i+7).getText())) {
                return true;
            }
        }

        /**CONTROLLO DIAGONALE DX*/
        for(int i = 3; i < 5; i=i+3) {
            System.out.println(" i vale "+ i);
            if(getButtonByIndex(i-1).getText().equals("")){
                continue;
            }

            if (getButtonByIndex(i-1).getText().equals(getButtonByIndex(i+1).getText())
                    && getButtonByIndex(i+1).getText().equals(getButtonByIndex(i+3).getText())) {
                return true;
            }
        }

        return false;
    }
}
