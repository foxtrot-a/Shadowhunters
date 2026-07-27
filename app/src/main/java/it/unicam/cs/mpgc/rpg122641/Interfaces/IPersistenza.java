package it.unicam.cs.mpgc.rpg122641.Interfaces;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Stato;

public interface IPersistenza {
    void salvaDettagliPartita(Game game);
    Game caricaPartitaSalvata();
    Stato caricaStato();
    void salvaStato(Stato stato);
    Game caricaTemplate();
}
