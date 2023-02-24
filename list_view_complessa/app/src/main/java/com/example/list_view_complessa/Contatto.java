package com.example.list_view_complessa;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String nome;
    private Drawable image;

    public Contatto(String nome, Drawable image) {
        this.nome = nome;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", image=" + image +
                '}';
    }
}
