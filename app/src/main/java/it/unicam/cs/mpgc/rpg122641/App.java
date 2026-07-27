package it.unicam.cs.mpgc.rpg122641;
import it.unicam.cs.mpgc.rpg122641.Controllers.StartController;
import it.unicam.cs.mpgc.rpg122641.Interfaces.IPersistenza;
import it.unicam.cs.mpgc.rpg122641.Models.*;
import it.unicam.cs.mpgc.rpg122641.Utils.JsonFileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static App instance;
    private Game game;
    private boolean partitaSalvata;
    private TestiPersistenza testi;
    private GamePersistence gamePersistence;
    private IPersistenza repository;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public TestiPersistenza getTesti() {
        return testi;
    }
    public GamePersistence getGestore() { return gamePersistence ;}
    @Override
    public void start(Stage stage) throws Exception {

        repository = new JsonPersistenza();
        game = loadGame();
        game.setCalcolatorePunteggio(new CalcolatorePunteggio());
        testi = loadTesti();
        gamePersistence = new GamePersistence(repository);
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
        Stato stato = repository.caricaStato();
        partitaSalvata = stato.isPartitaSalvata();
        if (partitaSalvata) {
             return repository.caricaPartitaSalvata();
        }
        return repository.caricaTemplate();
    }
    private TestiPersistenza loadTesti(){
        return (TestiPersistenza) JsonFileManager.recupera(new TestiPersistenza(), "testi.json");
    }
    public static void main(String[] args) {
        launch(args);
    }
}