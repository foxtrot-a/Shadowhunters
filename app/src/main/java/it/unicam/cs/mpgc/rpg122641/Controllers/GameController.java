package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

private Game game; // oggetto gioco principale
private  int scenario; // per recuperare gli oggetti dello scenario specificato

// qui inseriamo il riferimento alla label o agli oggetti che ci servono del file FXML
    @FXML
    TextArea pp;
    @FXML
    private ImageView img1;



    @FXML
    public void setGame (Game game){ //quando passiamo l'oggetto gioco, settiamo anche le varie label
                                    // che ci servono
        this.game = game;
        Room room = game.getRooms().get(scenario-1);
        pp.setText(room.getText());     // inseriamo il testo nella parte bianca
        // inseriremo anche le immagini e altro che mi serve
    }

   public  void setScenario(int i) {
        this.scenario = i;
    }


    // il giocatore può effettuare una scelta, quindi una mossa
    @FXML
    private void mossa(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        System.out.println(button.getId());
        switch (button.getId()) {
            case "1": // attacca

                 int esito = this.game.assegnaEsito(this.game.getShadowhunters().getAttacco(), this.game.getRooms().get(scenario-1).getDaemon().getDifesa());

                System.out.println(esito);
                 if (esito > 0){


            Image image = new Image(getClass().getResourceAsStream("/images/spada.png"));
            img1.setImage(image);

}else{
    //todo
    //togliamo l'esito
}


                break;

            case "2": //difendi

               esito = this.game.assegnaEsito(this.game.getRooms().get(scenario-1).getDaemon().getDifesa(), this.game.getShadowhunters().getAttacco());
                if (esito > 0){
                    Image image = new Image(getClass().getResourceAsStream("/images/spada.png"));
                    img1.setImage(image);

                }else{
                    //todo
                    //togliamo l'esito
                }


                break;

            case "3": //fuggi

                //this.game.
                this.back(event);
                break;

            case "4": //evocare Angelo

                //this.game.
                this.back(event);
                break;

        }

    }

//metodo per tornare indietro, riutulizzabile in più punti
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
