package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.App;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import it.unicam.cs.mpgc.rpg122641.Models.Shadowhunters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
public class RoomController implements IController {
    private Game game;

    public void setGame (Game game){
        this.game = game;
    }
    @FXML
    private void scenario(MouseEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game-view.fxml"));

            Parent root = loader.load();

            GameController controller = loader.getController();
            //recuperiaro il luogo selezionato
            StackPane stackPane = (StackPane) event.getSource();
            String id = stackPane.getId();
            int scena = Integer.parseInt(id);


            controller.setScenario(scena);
            controller.setGame(game);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root,800,700));

            stage.setOnCloseRequest(e -> {
                App.getInstance().getGestore().salvaPartita(game);
               // game.salvaPartita();
            });


            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}