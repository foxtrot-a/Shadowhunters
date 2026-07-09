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
        int danno =0;
//        switch (scelta){
//            case 1:  // attacca
//                danno  = var1-var2;
//                break;
//            case 2:  // difesa
//                danno  = var2-var1;
//                break;
//            case 3: //fuggi
//                danno = -1;
//                break;
//        }
danno = var1 - var2;
        switch (scenario) {
            case 1: //todo
                //la stanza 1 deve avere un comportamento differente dalle altre, perhcè ha
                //un ulteriore requisito per ricevere l'oggetto, che in questo caso sarà l'Angelo
                if (this.getRooms().get(1).isDone() == true &&
                        this.getRooms().get(3).isDone() == true &&
                        danno > 0){
                    // significa che ci sono due strumenti mortali e ha superato il demone
                } else{

                }


                break;

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println(var1);
                System.out.println(var2);
                System.out.println(danno);
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
                break;

            default:
                break;
        }

        return danno;

    }

    private void setGioco(){


    }


}
