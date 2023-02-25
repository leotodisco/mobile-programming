package com.example.esercizio_ale;

import android.os.Parcelable;

import java.io.Serializable;

public class Contatto implements Serializable {
    String nome;
    String numero;

    public Contatto(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
