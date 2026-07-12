package it.unicam.cs.mpgc.rpg122641.Interfaces;

import it.unicam.cs.mpgc.rpg122641.Models.Testi;

public interface ITestiRepository {
    Testi findByIdAndTipo(int id, char tipo);
}
