package it.unicam.cs.mpgc.rpg122641.Models;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IGestoreSalvataggioPartita;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;

public class GestoreSalvataggioPartita implements IGestoreSalvataggioPartita {
    private final IPersistenza repository;
        public GestoreSalvataggioPartita(IPersistenza repository){
        this.repository = repository;
    }

    @Override
    public void salvaPartita(Game game){
        repository.salvaDettagliPartita(game);
        Stato stato = repository.caricaStato();
        stato.setPartitaSalvata(game.getShadowhunters().isVivo());
        repository.salvaStato(stato);
    }
    @Override
    public void  resetPartita(Game game){
        game.resetGioco(repository.caricaTemplate());
    }
}
