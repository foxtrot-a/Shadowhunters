package it.unicam.cs.mpgc.rpg122641.Models;

import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;
import it.unicam.cs.mpgc.rpg122641.Utils.Persistenza;

public class JsonPersistenza implements IPersistenza {

@Override
    public void salva(Game game) {
        Persistenza.memorizza(game, "partita.json");
    }
    @Override
    public Game carica() {
        return (Game) Persistenza.recupera(new Game(), "partita.json");
    }
    @Override
    public Game caricaTemplate() {
        return (Game) Persistenza.recupera(new Game(), "gioco.json");
    }
    @Override
    public Stato caricaStato() {
        return (Stato) Persistenza.recupera(new Stato(), "statoPartita.json");
    }
    @Override
    public void salvaStato(Stato stato) {
        Persistenza.memorizza(stato, "statoPartita.json");
    }

}
