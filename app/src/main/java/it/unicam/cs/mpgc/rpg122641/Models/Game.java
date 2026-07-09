package it.unicam.cs.mpgc.rpg122641.Models;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Game {

    private Shadowhunters shadowhunters;
    private ArrayList<Room> rooms;
    private boolean evocaRaziel; // variabile per vedere se si può eseguire questa determinata mossa

    private int call_room ;

    public Game(Shadowhunters shadowhunters, ArrayList<Room> rooms){
        this.rooms = rooms;
        this.shadowhunters = shadowhunters;
        this.evocaRaziel = false;
    }
    public Shadowhunters getShadowhunters() {
        return shadowhunters;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // logica del gioco per combattimenti
    public int mossa(int var1, int var2, int scenario, int scelta){

        int danno = var1 - var2;

        switch (scenario) {
            case 1:
                //la stanza 1 deve avere un comportamento differente dalle altre, perhcè ha
                //un ulteriore requisito per ricevere l'oggetto, che in questo caso sarà l'Angelo
                if (this.getRooms().get(1).isDone() == true && this.getRooms().get(3).isDone() == true && danno > 0){
                    // significa che ci sono due strumenti mortali e ha superato il demone
                    this.setGioco( var1, var2,  scenario, scelta, danno); // scenario superato e si può aggiungere Raziel come oggetto
                } else{
                    // il demone ritorna sempre, perchè la scena non è completa, perchè rchieste anche gli altri due strumenti
                    this.getRooms().get(scenario-1).getDaemon().setAttacco(this.getRooms().get(scenario-1).getDaemon().getAttacco()+5);
                    this.getRooms().get(scenario-1).getDaemon().setDifesa(this.getRooms().get(scenario-1).getDaemon().getDifesa()+5);
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7: this.setGioco( var1, var2,  scenario, scelta, danno);
                break;
            default:
                break;
        }
        return danno;
    }

    // metodo in comune nel metodo della mossa, poichè c'è una piccola variazione tra la stanza 1 e le altre,
    // quindi raggruppiamo qui i calcoli
    private void setGioco(int var1, int var2, int scenario, int scelta, int danno){
        if (danno > 0){ // il giocatore ha vinto contro il mostro
            // il demone è sconfitto e azzeriamo i suoi parametri di gioco
            this.getRooms().get(scenario-1).getDaemon().setAttacco(0);
            this.getRooms().get(scenario-1).getDaemon().setDifesa(0);
            // settiamo che abbiamo superato la stanza
            this.getRooms().get(scenario-1).setDone(true);

            // aggiorniamo il punteggio del giocatore
            if (scelta == 1){
                this.shadowhunters.setAttacco(this.shadowhunters.getAttacco()+danno);
            }else if (scelta == 2){
                this.shadowhunters.setDifesa(this.shadowhunters.getDifesa()+danno);
            }
        }else{
            //il demone ha vinto e aggiungiamo a lui il punteggio

            // aggiorniamo il punteggio del demone, in base alla mosa fatta dal giocatore
            if (scelta == 1){
                this.getRooms().get(scenario-1).getDaemon().setAttacco( this.getRooms().get(scenario-1).getDaemon().getAttacco()+danno);
            }else if (scelta == 2){
                this.getRooms().get(scenario-1).getDaemon().setAttacco( this.getRooms().get(scenario-1).getDaemon().getDifesa()+danno);
            }else if(scelta == 3){
                // se il giocatore ha scelto fuggi, togliamo il punteggio
                this.shadowhunters.setAttacco(this.shadowhunters.getAttacco()+danno);
                this.shadowhunters.setDifesa(this.shadowhunters.getDifesa()+danno);
            }
        }
    }
}
