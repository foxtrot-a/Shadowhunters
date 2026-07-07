package it.unicam.cs.mpgc.rpg122641.Models;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Game {

    private Shadowhunters shadowhunters;
    private ArrayList<Room> rooms;
    private boolean evocaRaziel; // variabile per vedere se si può eseguire questa determinata mossa

    private int call_room ;

    public Game(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
        this.evocaRaziel = false;
    }

    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public boolean isEvocaRaziel() {
        return evocaRaziel;
    }

    public int getCall_room() {
        return call_room;
    }
    public void setCall_room(int call_room) {
        this.call_room = call_room;
    }

    public int assegnaEsito(int var1, int var2){

        int danno = var1-var2;
        return danno;

    }
}
