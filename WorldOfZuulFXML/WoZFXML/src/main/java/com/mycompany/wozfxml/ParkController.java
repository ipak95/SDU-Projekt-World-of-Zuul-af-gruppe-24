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

/**
 * FXML Controller class
 *
 * @author thkri
 */
public class ParkController implements Initializable {

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
    private void switchToMall() throws IOException {
        App.setRoot("Mall");
        App.game.setCurrentRoom("Mall");
        //App.game. / Insert method or event handler
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
