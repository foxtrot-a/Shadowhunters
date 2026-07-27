package it.unicam.cs.mpgc.rpg122641.Models;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;

public class GestoreSalvataggioPartita {
    private final IPersistenza repository;
        public GestoreSalvataggioPartita(IPersistenza repository){
        this.repository = repository;
    }
    public void salvaPartita(Game game){
        repository.salvaDettagliPartita(game);
        Stato stato = repository.caricaStato();
        stato.setPartitaSalvata(game.getShadowhunters().isVivo());
        repository.salvaStato(stato);
    }
    public void  resetPartita(Game game){
        game.resetGioco(repository.caricaTemplate());
    }
}
