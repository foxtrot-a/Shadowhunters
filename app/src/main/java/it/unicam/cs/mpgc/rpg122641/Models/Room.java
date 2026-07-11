package it.unicam.cs.mpgc.rpg122641.Models;

public class Room {
    private int id; // identificativo della stanza
    private String name; // nome del luogo
    private Daemon daemon; // demone presente nella stanza
    private ObjectRoom object; // oggetto magico che si recupera nella stanza se si uccide il demone
    private  String text; // testo per la storia narrativa

    private boolean done; // serve per sapere se la stanza è stata superata

    public Room(int id, String name, Daemon daemon, ObjectRoom object, String text) {
        this.id = id;
        this.name = name;
        this.daemon = daemon;
        this.object = object;
        this.text = text;
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

    public ObjectRoom getObject() {
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
