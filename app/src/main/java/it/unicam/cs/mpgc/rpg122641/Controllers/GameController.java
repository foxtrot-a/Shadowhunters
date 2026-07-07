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
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;



    @FXML
    public void setGame (Game game){ //quando passiamo l'oggetto gioco, settiamo anche le varie label
                                    // che ci servono
        this.game = game;
        Room room = game.getRooms().get(scenario-1);
        pp.setText(room.getText());     // inseriamo il testo nella parte bianca

        for(int i = 0; i < this.game.getRooms().size(); i++){
            if (this.game.getRooms().get(i).isDone() == true){
                // recuperiamo l'immagine dell'oggetto dal game
                String immagine = "/images/" + this.game.getRooms().get(i).getImmagine();
//System.out.println(immagine);
                Image image = new Image(getClass().getResourceAsStream(immagine));
                setImmagineOggetti(image);
              }
        }
    }

   public  void setScenario(int i) {
        this.scenario = i;
    }


    // il giocatore può effettuare una scelta, quindi una mossa
    @FXML
    private void mossa(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        System.out.println(button.getId());

        int esito = 0;
        switch (button.getId()) {
            case "1": // attacca
                esito = this.game.assegnaEsito(this.game.getShadowhunters().getAttacco(), this.game.getRooms().get(scenario-1).getDaemon().getDifesa());
                break;
            case "2": //difendi
                esito = this.game.assegnaEsito(this.game.getRooms().get(scenario-1).getDaemon().getDifesa(), this.game.getShadowhunters().getAttacco());
                break;
            case "3": //fuggi
                this.back(event);
                break;
        }

        // settiamo le immagini degli oggetti
        if (esito > 0){ // se abbiamo vinto, perchè abbiamo preso l'oggetto magico
            String immagine = "/images/" + this.game.getRooms().get(scenario-1).getImmagine();
            Image image = new Image(getClass().getResourceAsStream(immagine));
            this.setImmagineOggetti(image);
            this.game.getRooms().get(scenario-1).setDone(true);
        }
    }

    private void setImmagineOggetti(Image image){

        if (img1.getImage() == null){
            img1.setImage(image);
        } else
        if(img2.getImage() == null){
            img2.setImage(image);
        } else
        if (img3.getImage() == null){
            img3.setImage(image);
        } else
        if (img4.getImage() == null){
            img4.setImage(image);
        } else
        if (img5.getImage() == null){
            img5.setImage(image);
        } else
        if (img6.getImage() == null){
            img6.setImage(image);
        } else
        if (img7.getImage() == null){
            img7.setImage(image);
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
