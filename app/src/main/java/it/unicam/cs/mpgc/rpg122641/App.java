package it.unicam.cs.mpgc.rpg122641;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                //  getClass().getResource("/main-view.fxml")
                getClass().getResource("/view/main-view.fxml")
        );

        Scene scene = new Scene(loader.load(), 600, 700);
      //  stage.setFullScreen(true);
        stage.setTitle("Shadowhunters");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}