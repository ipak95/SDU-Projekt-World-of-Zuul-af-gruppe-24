package Domain;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class HelpPopup {
   
    
public void display()
{
Stage popupwindow=new Stage();
      
popupwindow.initModality(Modality.APPLICATION_MODAL);
popupwindow.setTitle("World of Sool - Help");
      
      
Label label1= new Label("Here is a long text explainging the game \n and helping you understand it");
      
     
Button button1= new Button("Close the Help tab");
     
     
button1.setOnAction(e -> popupwindow.close());
     
     

VBox layout= new VBox(10);
     
      
layout.getChildren().addAll(label1, button1);
      
layout.setAlignment(Pos.CENTER);
      
Scene scene1= new Scene(layout, 300, 250);
      
popupwindow.setScene(scene1);
      
popupwindow.showAndWait();
       
}

}