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
public class MallController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void switchToPark() throws IOException {
        App.setRoot("Park");
        //App.game. / Insert method or event handler
    }
    
    @FXML
    private void switchToRoof() throws IOException {
        App.setRoot("Roof");
        //App.game. / Insert method or event handler
    }
    
     @FXML
    private void switchToUniversity() throws IOException {
        App.setRoot("University");
        //App.game. / Insert method or event handler
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}