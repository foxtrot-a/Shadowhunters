package it.unicam.cs.mpgc.rpg122641.Controllers;

import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import it.unicam.cs.mpgc.rpg122641.Models.Shadowhunters;
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
    private Game game;

    public void setGame (Game game){
        this.game = game;
    }
    @FXML
    private void scenario1(MouseEvent event) {

      try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game-view.fxml"));

            Parent root = loader.load();

            GameController controller = loader.getController();
            controller.setGame(game);
            controller.setScenario(1);

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