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
      
      
Label label1= new Label("This game is about you wanting to learn more about solar panels\n"
        + "and solar power - how they are used and why we should use them even more \n"
        + "\n"
        + "Explore the city and its surroundings by using the buttons \n"
        + "to get to a new location. Have a look around with the Look-command \n"
        + "and interact with people by using Talk. \n"
        + "\n"
        + "Collect all the solar panel parts by answering all the questions correctly \n"
        + "and finally build your own solar panel!");
      
     
Button button1= new Button("Close Help");
     
     
button1.setOnAction(e -> popupwindow.close());
     
     

VBox layout= new VBox(10);
     
      
layout.getChildren().addAll(label1, button1);
      
layout.setAlignment(Pos.CENTER);
      
Scene scene1= new Scene(layout, 450, 300);
      
popupwindow.setScene(scene1);
      
popupwindow.showAndWait();
       
}

}