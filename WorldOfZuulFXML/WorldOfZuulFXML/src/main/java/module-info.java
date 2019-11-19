module com.mycompany.worldofzuulfxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.worldofzuulfxml to javafx.fxml;
    exports com.mycompany.worldofzuulfxml;
}