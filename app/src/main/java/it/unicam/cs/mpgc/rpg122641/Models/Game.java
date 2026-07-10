package it.unicam.cs.mpgc.rpg122641.Models;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

    private Shadowhunters shadowhunters;
    private ArrayList<Room> rooms;
    public Game(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
    }
    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // logica del gioco per combattimenti
    public boolean mossa(int var1, int var2, int scenario, int scelta){
        int danno = this.calcolaDanno(var1,var2);
        if (scenario == 1){
            return this.stanzaUno(scenario, scelta, danno);
        }else{
            this.setGioco(scenario, scelta, danno);
            return danno > 0;
        }
    }

    // metodo in comune nel metodo della mossa, poichè c'è una piccola variazione tra la stanza 1 e le altre,
    // quindi raggruppiamo qui i calcoli
    private void setGioco(int scenario, int scelta, int danno){
        Room room = rooms.get(scenario - 1);
        Daemon daemon = room.getDaemon();
       if (danno > 0) {
            // Il giocatore ha vinto
            this.gestisciVittoria(daemon,room,scelta,danno);
        } else {
            // Il demone ha vinto
            this.gestisciSconfitta(daemon,room,scelta,danno);

        }
    }

    private void gestisciVittoria(Daemon daemon, Room room, int scelta, int danno){
        daemon.setAttacco(0);
        daemon.setDifesa(0);
        room.setDone(true);

        switch (scelta){
            case 1: shadowhunters.setAttacco(shadowhunters.getAttacco() + danno + room.getObject().getScoreIncrements());
                break;
            case 2: shadowhunters.setDifesa(shadowhunters.getDifesa() + danno);
                break;
        }
    }

    private void gestisciSconfitta(Daemon daemon, Room room, int scelta, int danno){
        switch (scelta){
            case 1:  daemon.setAttacco(daemon.getAttacco() + danno);
                break;
            case 2:  daemon.setDifesa(daemon.getDifesa() + danno);
                break;
            case 3:
                shadowhunters.setAttacco(shadowhunters.getAttacco() + danno);
                shadowhunters.setDifesa(shadowhunters.getDifesa() + danno);
                break;
        }
    }
private boolean stanzaUno(int scenario, int scelta, int danno){
    //la stanza 1 deve avere un comportamento differente dalle altre, perhcè ha
    //un ulteriore requisito per ricevere l'oggetto, che in questo caso sarà l'Angelo
    if (this.getRooms().get(1).isDone() && this.getRooms().get(3).isDone()  && danno > 0){
        // significa che ci sono due strumenti mortali e ha superato il demone
        this.setGioco( scenario, scelta, danno); // scenario superato e si può aggiungere Raziel come oggetto
        return  true;
    } else if (danno > 0) {
        // il demone ritorna sempre, perchè la scena non è completa, perchè rchieste anche gli altri due strumenti
        this.getRooms().get(scenario - 1).getDaemon().setAttacco(this.getRooms().get(scenario - 1).getDaemon().getAttacco() + 5);
        this.getRooms().get(scenario - 1).getDaemon().setDifesa(this.getRooms().get(scenario - 1).getDaemon().getDifesa() + 5);
        return true;// ritorniamo true, perchè ha vinto, ma non ha superato il gioco
    }
return  false;
}

private int calcolaDanno(int punteggio1, int punteggio2){
        return punteggio1 - punteggio2;
}


private void resetGioco(){
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Game game = null; // game è l'oggetto che ha tutte le info del gioco
    try (FileReader reader = new FileReader("gioco.json")) {
        game   = gson.fromJson(reader, Game.class);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
