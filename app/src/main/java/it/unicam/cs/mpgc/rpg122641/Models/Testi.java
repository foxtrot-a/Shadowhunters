package it.unicam.cs.mpgc.rpg122641.Models;

public class Testi {
    private int id;
    private char tipo;
    private  String testo;
    public Testi (int id, String testo, char tipo){
        this.id = id;
        this.testo = testo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public char getTipo() {
        return tipo;
    }

    public String getTesto() {
        return testo;
    }
}
