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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GameController {

    private Game game; // oggetto gioco principale
    private Room room; // anche se posso recuperarlo dal game, uso molte volte tutto il recupero, poco leggibile
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
    private Label attacco;
    @FXML
    private Label difesa;
    @FXML
    private Label mostroAttacco;
    @FXML
    private Label mostroDifesa;
    @FXML
    private Label esitoRoom;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    private List<ImageView> immagini;
    @FXML
    public void setGame (Game game){ //quando passiamo l'oggetto gioco, settiamo anche le varie label che ci servono
        this.game = game;
        this.room = game.getRooms().get(scenario-1);
        pp.setText(this.room.getText());     // inseriamo il testo nella parte bianca
        this.setLabel();
        game.getRooms().stream().filter(Room::isDone).map(this::getRoomImage).forEach(this::setImmagineOggetti);
        if (room.isDone()){
            esitoRoom.setText("Sei già stato qui e hai vinto lo scontro!");
            this.setBottoni(false);
        }else{
            this.setBottoni(true);
        }
    }
    @FXML
    public void initialize(){
        immagini = List.of(img1, img2, img3, img4, img5, img6, img7);
    }

    public  void setScenario(int i) {
        this.scenario = i;
    }

    // il giocatore può effettuare una scelta, quindi una mossa
    @FXML
    private void mossa(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        boolean esito = false;
        int scelta = Integer.parseInt(button.getId().substring(2));
        switch (scelta) {
            case 1:// attacca
                esito = this.game.mossa(this.game.getShadowhunters().getAttacco(), this.room.getDaemon().getDifesa(),this.scenario,scelta);
                break;
            case 2: //difendi
                esito = this.game.mossa(this.game.getShadowhunters().getDifesa(), this.room.getDaemon().getAttacco(),this.scenario,scelta);
                break;
            case 3: //fuggi
                esito = this.game.mossa(this.room.getDaemon().getDifesa(), this.game.getShadowhunters().getAttacco(),this.scenario,scelta);
                break;
            case 4:
                this.back(event);
                return;
            case 5: this.game.resetGioco();
                    this.reStart(event);
                break;
        }
        this.aggiornaEsito(esito);
    }

    private void setImmagineOggetti(Image image){
        for(ImageView img : immagini){
            if(img.getImage() == null){
                img.setImage(image);
                break;
            }
        }
    }

    private void setBottoni(boolean valore){
            bt1.setVisible(valore);
            bt2.setVisible(valore);
            bt3.setVisible(valore);
            bt4.setVisible(!valore);
    }
    private void setLabel (){
        attacco.setText(String.valueOf(this.game.getShadowhunters().getAttacco()));
        difesa.setText(String.valueOf(this.game.getShadowhunters().getDifesa()));
        mostroAttacco.setText(String.valueOf(this.room.getDaemon().getAttacco()));
        mostroDifesa.setText(String.valueOf(this.room.getDaemon().getDifesa()));
    }

    private void aggiornaEsito(boolean esito){

        if (esito){ // se abbiamo vinto
           this.gestisciVittoria();
        }else{// se abbiamo perso
            this.gestisciSconfitta();
        }
    }

    private Image getRoomImage(Room room) {
        return new Image(getClass().getResourceAsStream("/images/" + room.getObject().getImmagePath()));
    }

    private void gestisciVittoria(){
        this.setLabel();
        this.setBottoni(false);
        if (this.scenario == 1 && !room.isDone()) {
            esitoRoom.setText("Scontro Vinto! Ma dovrai tornare per evocare l'Angeloe dovrai sconfiggere un nuvo demone, con il punteggio che vedi!");
        }else if (room.isDone() && this.scenario != 6) {
            esitoRoom.setText("Scontro Vinto! Sei un bravo Cacciatore di Demoni!");
            this.setImmagineOggetti(getRoomImage(room));}
        else if (room.isDone() && this.scenario == 6 ){
            esitoRoom.setText("Scontro Vinto con il Demone Superiore, Complimenti!");
            this.setImmagineOggetti(getRoomImage(room));
        }
    }

    private void gestisciSconfitta(){
        if (this.room.getDaemon().isDemoneSuperiore()){
            esitoRoom.setText("Hai perso lo scontro con il Demone Superiore! Game Over!");
            this.setBottoni(false);
            bt4.setVisible(false);
            bt5.setVisible(true);
        }else if (this.game.getShadowhunters().isVivo()) {
            esitoRoom.setText("Hai perso lo scontro, ma torna indietro e rimettiti in forze!");
            bt4.setVisible(true);
        }else{
            esitoRoom.setText("Game Over!");
            bt4.setVisible(false);
            bt5.setVisible(true);
        }
    }

    //metodo per tornare indietro, riutulizzabile in più punti
    public void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/room-view.fxml"));
        Parent root = loader.load();
        RoomController controller = loader.getController();
        controller.setGame(game);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }
    public void reStart(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main-view.fxml"));
        Parent root = loader.load();
        StartController controller = loader.getController();
        controller.setGame(game, false); // passiamo l'oggeto gioco che varrà per tutti i controller
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }



}