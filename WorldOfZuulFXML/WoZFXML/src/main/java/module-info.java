module com.mycompany.wozfxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.wozfxml to javafx.fxml;
    exports com.mycompany.wozfxml;
}