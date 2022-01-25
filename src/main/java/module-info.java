module com.example.loljbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;



    opens com.example.loljbc to javafx.fxml;
    exports com.example.loljbc;
}