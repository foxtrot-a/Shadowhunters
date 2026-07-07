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

import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Shadowhunters shadowhunters = new Shadowhunters(10,8);
        ArrayList<Room> rooms = new ArrayList<Room>();
        Daemon demone = new Daemon(5,3);

        Object object = new Object();
        Room stanza1 = new Room(1, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");



        Room stanza2 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");
          Room stanza3 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");
        Room stanza4 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");
        Room stanza5 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");
        Room stanza6 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");
        Room stanza7 = new Room(2, "Lago", demone,  object,
                "Benvenuto al Lago! Spero che tu abbia con te gli altri due Strumenti Mortali, perchè altrimenti sarebbe un po' inutile essere venuto qui...   " +
                        "Perchè il Lago è lo Specchio, il terzo Dono di Raziel, dove tra l'altro potrai evocarlo! " +
                        "Comunque adesso che fai? Ti difendi, Attacchi il Demone qui presente o...Scappi?",
                "Raziel.png");



        rooms.add(stanza1);
        rooms.add(stanza2);
        rooms.add(stanza3);
        rooms.add(stanza4);
        rooms.add(stanza5);
        rooms.add(stanza6);
        rooms.add(stanza7);
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