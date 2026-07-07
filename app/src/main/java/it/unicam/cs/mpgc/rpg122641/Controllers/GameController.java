package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
public class GameController {

private Game game; // oggetto gioco principale
private  int scenario; // per recuperare gli oggetti dello scenario specificato

// qui inseriamo il riferimento alla label o agli oggetti che ci servono del file FXML
    @FXML
    TextArea pp;
    @FXML
    public void setGame (Game game){ //quando passiamo l'oggetto gioo, settiamo anche le varie label
                                    // che ci servono
        this.game = game;
        Room room = game.getRooms().get(scenario-1);
        pp.setText(room.getText());     // inseriamo il testo nella parte bianca
    }

    @FXML
    private void evocaRaziel(ActionEvent event) {

   if (this.game.isEvocaRaziel() == true){

    //mostro immagine di raziel e poi aggiuntgo vita e torno indietro
        }else{
       // tolgo vita
   }
    }

   public  void setScenario(int i) {
        this.scenario = i;
    }

}
