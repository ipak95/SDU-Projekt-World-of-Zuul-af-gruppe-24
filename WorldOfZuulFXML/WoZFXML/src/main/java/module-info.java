module com.mycompany.wozfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.wozfxml to javafx.fxml;
    exports com.mycompany.wozfxml;
}