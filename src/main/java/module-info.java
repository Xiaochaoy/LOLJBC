module com.example.loljbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.support;
    requires org.seleniumhq.selenium.chrome_driver;
    requires com.opencsv;


    opens com.example.loljbc to javafx.fxml;
    exports com.example.loljbc;
    exports com.example.loljbc.controller;
    opens com.example.loljbc.controller to javafx.fxml;
    exports com.example.loljbc.conectar;
    opens com.example.loljbc.conectar to javafx.fxml;
}