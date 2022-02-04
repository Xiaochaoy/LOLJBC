module com.example.loljbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.support;
    requires org.seleniumhq.selenium.chrome_driver;


    opens com.example.loljbc to javafx.fxml;
    exports com.example.loljbc;
}