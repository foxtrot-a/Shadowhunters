package it.unicam.cs.mpgc.rpg122641;
import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Models.*;
import it.unicam.cs.mpgc.rpg122641.Utils.Persistenza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static App instance;
    private Game game;
    private boolean partitaSalvata;
    private TestiPersistenza testi;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public TestiPersistenza getTesti() {
        return testi;
    }
    @Override
    public void start(Stage stage) throws Exception {

        game = loadGame();
        game.setRepository(new JsonPeristenza());
        game.setCalcolatorePunteggio(new CalcolatorePunteggio());
        testi = loadTesti();
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

    private TestiPersistenza loadTesti(){
        return (TestiPersistenza) Persistenza.recupera(new TestiPersistenza(), "testi.json");
    }

    public static void main(String[] args) {
        launch(args);
    }
}