package it.unicam.cs.mpgc.rpg122641;

import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Models.Daemon;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Object;
import it.unicam.cs.mpgc.rpg122641.Models.Room;
import it.unicam.cs.mpgc.rpg122641.Models.Shadowhunters;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // recuperiamo le configurazioni memorizzate del gioco dal file json

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Game game = null; // game è l'oggetto che ha tutte le info del gioco

        try (FileReader reader = new FileReader("persona.json")) {

            game   = gson.fromJson(reader, Game.class);

        } catch (IOException e) {

           e.printStackTrace();

        }

        // una volta caricato il gioco, si parte!
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