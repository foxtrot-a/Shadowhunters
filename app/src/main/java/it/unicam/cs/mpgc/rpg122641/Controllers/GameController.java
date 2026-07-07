package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

private Game game; // oggetto gioco principale
private  int scenario; // per recuperare gli oggetti dello scenario specificato

// qui inseriamo il riferimento alla label o agli oggetti che ci servono del file FXML
    @FXML
    TextArea pp;
    @FXML
    public void setGame (Game game){ //quando passiamo l'oggetto gioco, settiamo anche le varie label
                                    // che ci servono
        this.game = game;
        Room room = game.getRooms().get(scenario-1);
        pp.setText(room.getText());     // inseriamo il testo nella parte bianca
        // inseriremo anche le immagini e altro che mi serve
    }

    @FXML
    private void evocaRaziel(ActionEvent event) {

   if (this.game.isEvocaRaziel() == true){

    //mostro immagine di raziel e poi aggiuntgo vita e torno indietro
        }else{
       // tolgo vita    //todo
   }
    }


    @FXML
    private void fuggi (ActionEvent event) throws IOException {

        // nel fuggi torniamo alla schermata delle scelte, ma togliamo punteggio
        this.back(event);

    }


    @FXML
    private void attacca (ActionEvent event) throws IOException {

        // nel fuggi torniamo alla schermata delle scelte, ma togliamo punteggio
        this.back(event);

    }


    @FXML
    private void difendi (ActionEvent event) throws IOException {

        // nel fuggi torniamo alla schermata delle scelte, ma togliamo punteggio
        this.back(event);

    }

   public  void setScenario(int i) {
        this.scenario = i;
    }

    // in questo metodo, raggruppiamo l'aggiornamento del risultato, dopo che
    // il giocatore ha fatto la sua mossa
    private void danno(){



    }


    private void back(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/room-view.fxml"));
        Parent root = loader.load();

        RoomController controller = loader.getController();
        controller.setGame(game);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 700));
        stage.show();

    }

}
