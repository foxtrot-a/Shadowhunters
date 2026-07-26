package it.unicam.cs.mpgc.rpg122641.Models;

import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;

public class GameGestore {
    private final IPersistenza repository;
        public GameGestore(IPersistenza repository){
        this.repository = repository;
    }

    public void salvaPartita(Game game){
        repository.salva(game);
        Stato stato = repository.caricaStato();
        stato.setPartitaSalvata(game.getShadowhunters().isVivo());
        repository.salvaStato(stato);
    }

    public void  resetPartita(Game game){
        Game template = repository.caricaTemplate();
        game.resetGioco(template);
    }
}
