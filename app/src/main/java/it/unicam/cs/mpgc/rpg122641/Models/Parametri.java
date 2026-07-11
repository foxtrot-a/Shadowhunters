package it.unicam.cs.mpgc.rpg122641.Models;

import java.util.ArrayList;

public class Parametri {
private Shadowhunters shadowhunters;
private ArrayList<Room> rooms;

    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public boolean isPartitaSalvata() {
        return partitaSalvata;
    }

    private boolean partitaSalvata;
    public Parametri(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
    }

    public Parametri(){

    }

}
