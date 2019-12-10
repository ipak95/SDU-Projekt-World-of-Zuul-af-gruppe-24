/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapPopUp {

    public void display() throws FileNotFoundException {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("World of Sool - Map");

        Image image = new Image(new FileInputStream("src/main/resources/com/mycompany/wozfxml/pics/Map_Home.png"));

        ImageView imageView = new ImageView(image);

        imageView.setX(2000);
        imageView.setY(1812);

        imageView.setFitHeight(500);
        imageView.setFitWidth(550);
        
        Button button = new Button("Close map");
        
        button.setOnAction(e -> popupwindow.close());
        
        VBox layout = new VBox(10);
        
        layout.getChildren().addAll(imageView, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 575, 575);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }

}
