package it.unicam.cs.mpgc.rpg122641.Models;

public abstract  class Personaggio {
    private int attacco;
    private int difesa;

    public Personaggio(int attacco, int difesa) {

        this.attacco = attacco;
        this.difesa = difesa;
    }


    public int getAttacco() {
        return attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    }
