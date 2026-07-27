package it.unicam.cs.mpgc.rpg122641.Models;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;
import it.unicam.cs.mpgc.rpg122641.Utils.JsonFileManager;

public class JsonPersistenza implements IPersistenza {
@Override
    public void salvaDettagliPartita(Game game) { JsonFileManager.memorizza(game, "partita.json"); }
    @Override
    public Game caricaPartitaSalvata() {
        return (Game) JsonFileManager.recupera(new Game(), "partita.json");
    }
    @Override
    public Game caricaTemplate() {
        return (Game) JsonFileManager.recupera(new Game(), "gioco.json");
    }
    @Override
    public Stato caricaStato() {
        return (Stato) JsonFileManager.recupera(new Stato(), "statoPartita.json");
    }
    @Override
    public void salvaStato(Stato stato) {
        JsonFileManager.memorizza(stato, "statoPartita.json");
    }
    @Override
    public TestiPersistenza caricaTesti() {  return (TestiPersistenza) JsonFileManager.recupera(new TestiPersistenza(), "testi.json");}
}