package it.unicam.cs.mpgc.rpg122641.Models;

import it.unicam.cs.mpgc.rpg122641.Interfaces.ICalcolaPunteggio;
public class CalcolatorePunteggio implements ICalcolaPunteggio {
    private static final int PENALITA_FUGA = -2;
    @Override
    public int calcolaEsito(Combattimento combattimento) {
        switch (combattimento.getAzione()) {
            case ATTACCA:
                return combattimento.getShadowhunters().getAttacco() - combattimento.getDaemon().getDifesa();
            case DIFENDI:
                return combattimento.getDaemon().getDifesa() - combattimento.getShadowhunters().getAttacco();
            case FUGGI:
                return PENALITA_FUGA;
            default:
                return 0;
        }
    }
}