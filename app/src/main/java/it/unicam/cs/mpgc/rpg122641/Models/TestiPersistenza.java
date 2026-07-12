package it.unicam.cs.mpgc.rpg122641.Models;

import it.unicam.cs.mpgc.rpg122641.Interfaces.ITestiRepository;

import java.util.List;

public class TestiPersistenza implements ITestiRepository {

    private List<Testi> testi;

    @Override
    public Testi findByIdAndTipo(int id, char tipo) {

        if (testi == null) {
            return null;
        }

        return testi.stream()
                .filter(t -> t.getId() == id && t.getTipo() == tipo)
                .findFirst()
                .orElse(null);
    }

    public List<Testi> getTesti() {
        return testi;
    }

    public void setTesti(List<Testi> testi) {
        this.testi = testi;
    }
}