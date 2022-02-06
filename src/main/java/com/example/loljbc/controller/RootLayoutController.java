package com.example.loljbc.controller;

import com.example.loljbc.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class RootLayoutController {

    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMain(Main mainApp) {
        this.main = mainApp;
    }


    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout() {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("LOL");
        a.setHeaderText("About");
        a.setContentText("Author: Xiaochao Ying");
        a.show();
    }

    @FXML
    private void handleShowBirthdayStatistics() {
        main.showBirthdayStatistics();
    }
}
