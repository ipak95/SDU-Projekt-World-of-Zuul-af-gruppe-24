package com.mycompany.wozfxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author thkri
 */
public class MallController implements Initializable {

    @FXML
    public TextArea longdescription;
    
    @FXML
    public TextArea QandA;
    
    @FXML
    private void switchToLongdesciption() throws IOException {
       longdescription.setText(App.game.lookAround());
    }
    
    @FXML
    private void switchToTalk() throws IOException {
       QandA.setText(App.game.talkTo());
    }
    @FXML
    private void switchToAnswerA() throws IOException {
       QandA.setText(App.game.answer('a'));
    }
    @FXML
    private void switchToAnswerB() throws IOException {
       QandA.setText(App.game.answer('b'));
    }
    @FXML
    private void switchToAnswerC() throws IOException {
       QandA.setText(App.game.answer('c'));
    }
    @FXML
    private void switchToAnswerD() throws IOException {
       QandA.setText(App.game.answer('d'));
    }
    @FXML
    private void switchToBuild() throws IOException {
       QandA.setText(App.game.buildToWin());
    }
    @FXML
    private void switchToViewInventory() throws IOException {
       QandA.setText(App.game.viewInventory());
    }
    @FXML
    private void switchToViewHelp() throws IOException {
       App.HelpPopup.display();
    }
    
    @FXML
    private void switchToPark() throws IOException {
        App.setRoot("Park");
        App.game.setCurrentRoom("Park");
    }
    
    @FXML
    private void switchToRoof() throws IOException {
        App.setRoot("Roof");
        App.game.setCurrentRoom("Rooftop");
    }
    
     @FXML
    private void switchToUniversity() throws IOException {
        App.setRoot("University");
        App.game.setCurrentRoom("University");
    }
    @FXML
    private void switchToQuit() throws IOException {
       App.QuitPopup.display();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}