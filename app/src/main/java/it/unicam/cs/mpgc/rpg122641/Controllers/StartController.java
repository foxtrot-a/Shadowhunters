package it.unicam.cs.mpgc.rpg122641.Controllers;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class StartController {
private Game game;


    @FXML
    private Button btnOld;

    public void setGame (Game game){
        this.game = game;
    }
    public void setBtn (boolean old){
        btnOld.setVisible(old);
    }

    @FXML
    private void goToGame(ActionEvent event) {

        Button buttonPremuto = (Button) event.getSource();

        if (!buttonPremuto.getId().equals("btnOld")) {
            this.game.resetGioco(this.game);
        }

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/guida-view.fxml"));

            Parent root = loader.load();

            GuideController controller = loader.getController();
            controller.setGame(game);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setOnCloseRequest(e -> {

                game.salvaPartita();
            });

            stage.setScene(new Scene(root,800,700));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}