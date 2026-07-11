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

    private static boolean old;

    public Game inizializzazione(){
        // recuperiamo le configurazioni memorizzate del gioco dal file json
        Game game = new Game(); // game è l'oggetto che ha tutte le info del gioco
        Stato par = new Stato();
        par = (Stato) Persistenza.recupera(par,"statoPartita.json");
        if (par.isPartitaSalvata()){
            game = (Game) Persistenza.recupera(game,"partita.json"); // recuperiamo i dati della partita precedente
       old =true;
        }else{
            game = (Game) Persistenza.recupera(game,"gioco.json");  // partita nuova
        }
        return game;
    }

    @Override
    public void start(Stage stage) throws Exception {


        // una volta caricato il gioco, si parte!
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main-view.fxml"));

        Scene scene = new Scene(loader.load(), 600, 700);

        StartController controller = loader.getController();
        controller.setGame(this.inizializzazione()); // passiamo l'oggeto gioco che varrà per tutti i controller
        controller.setBtn(old);
        stage.setTitle("Shadowhunters");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        old = false;
        launch();
    }
}