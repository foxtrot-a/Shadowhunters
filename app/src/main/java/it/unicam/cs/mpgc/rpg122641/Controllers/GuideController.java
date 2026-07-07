package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.Models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuideController {
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
            Parent root = FXMLLoader.load(getClass().getResource("/view/room-view.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}