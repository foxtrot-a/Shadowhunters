package it.unicam.cs.mpgc.rpg122641.Models;

import java.util.ArrayList;

public class Game {
    // qui mettiamo: il giocatore
    // mettiamo le stanze
    // mettiamo delle varibaili di controllo per il gioco

    private Shadowhunters shadowhunters;
    private ArrayList<Room> rooms;
    private boolean evocaRaziel;

    public Game(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
        this.evocaRaziel = false;
    }


}
