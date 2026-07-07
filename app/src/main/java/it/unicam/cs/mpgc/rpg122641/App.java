package it.unicam.cs.mpgc.rpg122641;

import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import it.unicam.cs.mpgc.rpg122641.Models.Shadowhunters;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Shadowhunters shadowhunters = new Shadowhunters();
        ArrayList<Room> rooms = new ArrayList<Room>();

        Game game = new Game( shadowhunters, rooms);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main-view.fxml"));

        Scene scene = new Scene(loader.load(), 600, 700);

        StartController controller = loader.getController();
        controller.setGame(game); // passiamo l'oggeto gioco che varrà per tutti i controller


        stage.setTitle("Shadowhunters");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}