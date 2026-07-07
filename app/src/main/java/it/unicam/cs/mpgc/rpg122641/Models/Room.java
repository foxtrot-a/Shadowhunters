package it.unicam.cs.mpgc.rpg122641.Models;

public class Room {
    private int id; // identificativo della stanza
    private String name; // nome del luogo
    private Daemon daemon; // demone presente nella stanza
    private Object object; // oggetto magico che si recupera nella stanza se si uccide il demone
    private  String text; // testo per la storia narrativa
    private String immagine;
    private boolean done;

    public String getImmagine() {
        return immagine;
    }

    public Room(int id, String name, Daemon daemon, Object object, String text, String immagine) {
        this.id = id;
        this.name = name;
        this.daemon = daemon;
        this.object = object;
        this.text = text;
        this.immagine = immagine;
        this.done = false; // mettiamo a false il fatto che la stanza è già stata superata
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Daemon getDaemon() {
        return daemon;
    }

    public Object getObject() {
        return object;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
