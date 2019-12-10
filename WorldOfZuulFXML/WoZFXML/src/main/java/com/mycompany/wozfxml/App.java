package com.mycompany.wozfxml;

import Domain.Room;
import Domain.Game;
import Domain.HelpPopup;
import Domain.QuitPopup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static Game game;
    
    public static HelpPopup HelpPopup;
    
    public static QuitPopup QuitPopup;
        
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 950, 944);
        game = new Game();
        HelpPopup = new HelpPopup();
        QuitPopup = new QuitPopup();
        stage.setTitle("World of Zuul (Group 24) - World Of Sool");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void load(String[] args) {
        launch();
    }

}