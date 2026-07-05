package it.unicam.cs.mpgc.rpg122641.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class StartController {

    @FXML
    private void goToGame(ActionEvent event) {
        try {
            // carica seconda pagina
            Parent root = FXMLLoader.load(getClass().getResource("/guida.fxml"));

            // prende lo stage attuale
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // cambia scena

            double w = stage.getScene().getWidth();
            double h = stage.getScene().getHeight();

            stage.setScene(new Scene(root, w, h));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}