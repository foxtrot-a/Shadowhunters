package it.unicam.cs.mpgc.rpg122641;
import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Models.Game;
import it.unicam.cs.mpgc.rpg122641.Models.Stato;
import it.unicam.cs.mpgc.rpg122641.Models.Persistenza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private Game game;
    private boolean partitaSalvata;

    @Override
    public void start(Stage stage) throws Exception {

        game = loadGame();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main-view.fxml"));
        Scene scene = new Scene(loader.load(), 600, 700);

        StartController controller = loader.getController();
        controller.setGame(game);
        controller.setBtn(partitaSalvata);

        stage.setTitle("Shadowhunters");
        stage.setScene(scene);
        stage.show();
    }

    private Game loadGame() {

        Stato stato = (Stato) Persistenza.recupera(new Stato(), "statoPartita.json");

        partitaSalvata = stato.isPartitaSalvata();

        if (partitaSalvata) {
            return (Game) Persistenza.recupera(new Game(), "partita.json");
        }

        return (Game) Persistenza.recupera(new Game(), "gioco.json");
    }

    public static void main(String[] args) {
        launch(args);
    }
}