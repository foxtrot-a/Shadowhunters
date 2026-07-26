package it.unicam.cs.mpgc.rpg122641.Models;

public class Combattimento {
    private Room room;
    private Shadowhunters shadowhunters;
    private Daemon daemon;
    private Azione azione;
    private boolean esito;

    public Combattimento( Room room,  Shadowhunters shadowhunters, Daemon daemon, Azione azione) {
        this.room = room;
        this.shadowhunters = shadowhunters;
        this.daemon = daemon;
        this.azione = azione;
        this.esito = false;
    }

    public Room getRoom() {
        return room;
    }

    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public Daemon getDaemon() {
        return daemon;
    }

    public Azione getAzione() {
        return azione;
    }
    public boolean getEsito() {
        return esito;
    }

}
