package it.unicam.cs.mpgc.rpg122641.Interfaces;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Stato;

public interface IPersistenza {
    void salva(Game game);

    Game carica();

    Stato caricaStato();

    void salvaStato(Stato stato);
     Game caricaTemplate();

}
