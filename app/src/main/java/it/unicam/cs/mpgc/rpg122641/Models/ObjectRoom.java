package it.unicam.cs.mpgc.rpg122641.Models;
public class ObjectRoom {

    private String name;
    private String immagePath;
    private int scoreIncrements;

    public ObjectRoom(String name, String immagePath, int scoreIncrements) {
        this.name = name;
        this.immagePath = immagePath;
        this.scoreIncrements = scoreIncrements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImmagePath(String immagePath) {
        this.immagePath = immagePath;
    }

    public void setScoreIncrements(int scoreIncrements) {
        this.scoreIncrements = scoreIncrements;
    }

    public String getName() {
        return name;
    }

    public String getImmagePath() {
        return immagePath;
    }

    public int getScoreIncrements() {
        return scoreIncrements;
    }
}
