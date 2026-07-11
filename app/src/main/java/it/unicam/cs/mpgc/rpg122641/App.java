package it.unicam.cs.mpgc.rpg122641;
import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Persistenza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // recuperiamo le configurazioni memorizzate del gioco dal file json

        Game game = new Game(); // game è l'oggetto che ha tutte le info del gioco
        game = (Game) Persistenza.recupera(game);


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