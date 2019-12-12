package Domain;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class QuitPopup {

    public void display() {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("World of Sool - Quit");

        Label label1 = new Label("Are you sure you want to quit?");

        Button button1 = new Button("Yes");
        Button button2 = new Button("No");

        button1.setOnAction(e -> System.exit(0));
        button2.setOnAction(e -> popupwindow.close());

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label1, button1, button2);

        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();
    }
}
