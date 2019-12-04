/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wozfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Kenneth
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
           
    @FXML
    private void switchToDowntown() throws IOException {
        App.setRoot("Downtown");
        App.game.setCurrentRoom("Downtown");
        
        //App.game. / Insert method or event handler
    }
    
    @FXML
    public TextArea longdescription;
    
    @FXML
    public TextArea QandA;
    
    @FXML
    private void switchToLongdesciption() throws IOException {
       longdescription.setText(App.game.lookAround());
        //App.game. / Insert method or event handler
    }
    
    @FXML
    private void switchToTalk() throws IOException {
       QandA.setText(App.game.talkTo());
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToAnswerA() throws IOException {
       QandA.setText(App.game.answer('a'));
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToAnswerB() throws IOException {
       QandA.setText(App.game.answer('b'));
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToAnswerC() throws IOException {
       QandA.setText(App.game.answer('c'));
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToAnswerD() throws IOException {
       QandA.setText(App.game.answer('d'));
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToBuild() throws IOException {
       QandA.setText(App.game.buildToWin());
        //App.game. / Insert method or event handler
    }
    @FXML
    private void switchToViewInventory() throws IOException {
       QandA.setText(App.game.viewInventory());
        //App.game. / Insert method or event handler
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
