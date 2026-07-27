package it.unicam.cs.mpgc.rpg122641.Interfaces;

import it.unicam.cs.mpgc.rpg122641.Models.Game;

public interface IGestoreSalvataggioPartita {
    void salvaPartita(Game game);
    void resetPartita(Game game);
}
