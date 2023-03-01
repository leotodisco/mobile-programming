package com.example.fragments_understanding;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Un frammento è una porzione di UI,
 * ogni fragment è ospitato da una activity, ma nonostante questo
 * ogni fragment ha un suo ciclo di vita che passa per vari stati.
 * Il vantaggio dei Fragment è che possono essere dinamici e quindi creati a runtime
 * e quindi poter gestire la view su schermi grandi e piccoli in modi diversi.
 * La classe extende Fragment, ma bisogna fare override di alucni metodi utili:
 *   1. onCreate -> qui si inizializza solo, non si pensa al layout
 *   2. onCreateView -> qui si crea il layout perciò si resituisce una view, è l’equivalente di setContentView nella activity host
 *   3. onPause -> viene chiamato quando il frammento si elimina, in questo metodo si salva lo stato del frammento. //opzionale
 *
 * Fragments possono sia essere inseriti staticamente nel file xml, sia a runtime
 * in modo dinamico con la classe FragmentManager e FragmentTransaction.
 *
 * La comunicazione fra frammenti non avviene maoi in modo diretto,
 * si passa sempre per la activity che ospita i frammenti.
 *
 * Per comunicare tra frammenti, un modo comune è quello di definire un'interfaccia all'interno del frammento
 * e far implementare l'interfaccia dall'activity contenitrice
 *
 * Il metodo .add() viene utilizzato per aggiungere un nuovo frammento alla transazione, creando una nuova istanza del frammento se necessario.
 * Se il frammento è già presente nel backstack della transazione,
 * verrà semplicemente riutilizzato e non verrà creata una nuova istanza.
 * Questo metodo accetta tre parametri: il contenitore in cui verrà visualizzato il frammento,
 * il frammento da aggiungere e un tag opzionale per il frammento.
 * Il metodo .attach() viene utilizzato per allegare un frammento già esistente alla transazione.
 * Questo significa che il frammento esiste già nella gerarchia della vista e verrà semplicemente spostato nel contenitore specificato.
 * Questo metodo accetta due parametri: il contenitore in cui verrà visualizzato il frammento e il frammento da allegare.
 */
public class FrammentoAQ extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /**
         * qui sto facendo un inflate di un file xml che è il mio frammento.
         */
        View v = inflater.inflate(R.layout.frammento_a, container, false);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
