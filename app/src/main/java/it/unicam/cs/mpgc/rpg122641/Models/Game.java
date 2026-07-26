package it.unicam.cs.mpgc.rpg122641.Models;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;
import it.unicam.cs.mpgc.rpg122641.Interfaces.ICalcolaPunteggio;
import java.util.ArrayList;
public class Game {
    private Shadowhunters shadowhunters;
    private ArrayList<Room> rooms;
    private transient ICalcolaPunteggio calcolatorePunteggio;

    public Game(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
    }
    public Game(){

    }
    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // logica del gioco per combattimenti
    public boolean azioneUtente(int scenario, Azione azione){
        int danno =  calcolatorePunteggio.calcolaEsito(new Combattimento(
                                                             this.getRooms().get(scenario-1),
                                                             this.shadowhunters,
                                                             this.getRooms().get(scenario-1).getDaemon(),
                                                             azione));

        if (scenario == 1){
            return this.stanzaUno(scenario, azione, danno);
        }else{
            this.setGioco(scenario, azione, danno);
            return danno > 0;
        }
    }

    // metodo in comune nel metodo della mossa, poichè c'è una piccola variazione tra la stanza 1 e le altre,
    // quindi raggruppiamo qui i calcoli
    private void setGioco(int scenario, Azione azione, int danno){
        Room room = rooms.get(scenario - 1);
        Daemon daemon = room.getDaemon();
       if (danno > 0) {
            // Il giocatore ha vinto
            this.gestisciVittoria(daemon,room,azione,danno);
        } else {
            // Il demone ha vinto
            this.gestisciSconfitta(daemon,room,azione,danno);

        }
    }

    private void gestisciVittoria(Daemon daemon, Room room, Azione azione, int danno){
        daemon.setAttacco(0);
        daemon.setDifesa(0);
        room.setDone(true);

        switch (azione){
            case ATTACCA: shadowhunters.setAttacco(shadowhunters.getAttacco() + danno + room.getObject().getScoreIncrements());
                break;
            case DIFENDI: shadowhunters.setDifesa(shadowhunters.getDifesa() + danno);
                break;
        }
    }

    private void gestisciSconfitta(Daemon daemon, Room room, Azione azione, int danno){

        switch (azione){
            case ATTACCA:  daemon.setAttacco(daemon.getAttacco() + danno);
                    shadowhunters.setDifesa(shadowhunters.getDifesa() + danno);
                break;
            case DIFENDI:  daemon.setDifesa(daemon.getDifesa() + danno);
                    shadowhunters.setAttacco(shadowhunters.getAttacco() + danno);
                break;
            case FUGGI:
                shadowhunters.setAttacco(shadowhunters.getAttacco() + danno);
                shadowhunters.setDifesa(shadowhunters.getDifesa() + danno );
                break;
        }
    }
private boolean stanzaUno(int scenario, Azione azione, int danno){
    //la stanza 1 deve avere un comportamento differente dalle altre, perhcè ha
    //un ulteriore requisito per ricevere l'oggetto, che in questo caso sarà l'Angelo
    if (this.getRooms().get(1).isDone() && this.getRooms().get(3).isDone()  && danno > 0){
        // significa che ci sono due strumenti mortali e ha superato il demone
        this.setGioco( scenario, azione, danno); // scenario superato e si può aggiungere Raziel come oggetto
        return  true;
    } else if (danno > 0) {
        // il demone ritorna sempre, perchè la scena non è completa, perchè rchieste anche gli altri due strumenti
        this.getRooms().get(scenario - 1).getDaemon().setAttacco(this.getRooms().get(scenario - 1).getDaemon().getAttacco() + 5);
        this.getRooms().get(scenario - 1).getDaemon().setDifesa(this.getRooms().get(scenario - 1).getDaemon().getDifesa() + 5);
        return true;// ritorniamo true, perchè ha vinto, ma non ha superato il gioco
    }
return  false;
}


public void resetGioco(Game template){
//    Game template = repository.caricaTemplate();
    shadowhunters.setAttacco(template.getShadowhunters().getAttacco());
    shadowhunters.setDifesa(template.getShadowhunters().getDifesa());

    for (int i = 0; i < rooms.size(); i++){
     rooms.get(i).setDone(false);
     rooms.get(i).getDaemon().setDifesa(template.getRooms().get(i).getDaemon().getDifesa());
     rooms.get(i).getDaemon().setAttacco(template.getRooms().get(i).getDaemon().getAttacco());
     }
}
    public void setCalcolatorePunteggio(ICalcolaPunteggio calcolatorePunteggio) {
        this.calcolatorePunteggio = calcolatorePunteggio;
    }


}
