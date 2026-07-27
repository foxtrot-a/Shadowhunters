package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.App;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuideController implements IController {
    private Game game;

    public void setGame (Game game){
        this.game = game;
    }
    @FXML
    private void startGame(ActionEvent event) {
        goToGame(event);
    }


    @FXML
    private void goToGame(ActionEvent event) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/room-view.fxml"));

            Parent root = loader.load();

            RoomController controller = loader.getController();
            controller.setGame(game);


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root,800,700));

            stage.setOnCloseRequest(e -> {
                App.getInstance().getGestore().salvaPartita(game);
               });


            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}