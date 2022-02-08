package com.example.loljbc.controller;

import com.example.loljbc.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

public class RootLayoutController {

    private Main main;
    public static boolean cambio = true;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMain(Main mainApp) {
        this.main = mainApp;
    }

    @FXML
    private BorderPane borderPane;

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
    private void handleShowStatistics() {
        main.showStatistics();
    }

    @FXML
    private void handleStartRobo(){
        main.startRobo();
    }

    @FXML
    private void handleCambiEstilo(){

        if (cambio){
            borderPane.getStylesheets().clear();
            borderPane.getStylesheets().add(Main.class.getResource("estilo2.css").toExternalForm());
            cambio = false;
        }else {
            borderPane.getStylesheets().clear();
            borderPane.getStylesheets().add(Main.class.getResource("DarkTheme.css").toExternalForm());
            cambio = true;
        }

    }
}
