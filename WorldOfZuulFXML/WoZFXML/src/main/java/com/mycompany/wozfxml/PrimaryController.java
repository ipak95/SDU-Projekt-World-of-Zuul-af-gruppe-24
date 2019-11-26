package com.mycompany.wozfxml;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Home");
        //App.game. / Insert method or event handler
    }
}
