package it.unicam.cs.mpgc.rpg122641.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
public class RoomController{

    @FXML
    private void scenario1(MouseEvent event) {

        // qui devo:
        // caricare immagine del demone;
        // recuperare le frasi
        // attacco e difesa del demone
        //recuperare l'oggetto magico

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/game-view.fxml"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setFullScreen(true);

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void scenario2() {System.out.println("Hai selezionato lo scenario 2"); }

    @FXML
    private void scenario3() {
        System.out.println("Hai selezionato lo scenario 3");
    }

    @FXML
    private void scenario4() {
        System.out.println("Hai selezionato lo scenario 4");
    }

    @FXML
    private void scenario5() {
        System.out.println("Hai selezionato lo scenario 5");
    }

    @FXML
    private void scenario6() {
        System.out.println("Hai selezionato lo scenario 6");
    }

    @FXML
    private void scenario7() {
        System.out.println("Hai selezionato lo scenario 7");
    }


}