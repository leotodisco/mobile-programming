package com.example.comunicazione_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class FrammentoA extends Fragment {
    TextView tv;
    EditText et;

    public interface ComunicazioneInterface {
        public void settaTesto(String s);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frammento, container, false);

        tv = (TextView) v.findViewById(R.id.testo);
        et = (EditText) v.findViewById(R.id.edit);

        return v;
    }

    public void updateText(CharSequence txt) {
        this.tv.setText(txt);
    }

}
