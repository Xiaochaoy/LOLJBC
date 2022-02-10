package com.example.loljbc.controller;

import com.example.loljbc.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class RootLayoutController {

    private Main main;
    private boolean cambio = true;

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
        TabPane tabPane = main.pillarTabPane();
        if (cambio){
            tabPane.getStylesheets().clear();
            borderPane.getStylesheets().clear();
            tabPane.getStylesheets().add(Main.class.getResource("estilo2.css").toExternalForm());
            borderPane.getStylesheets().add(Main.class.getResource("estilo2.css").toExternalForm());
            cambio = false;
        }else {
            tabPane.getStylesheets().clear();
            borderPane.getStylesheets().clear();
            tabPane.getStylesheets().add(Main.class.getResource("estilo1.css").toExternalForm());
            borderPane.getStylesheets().add(Main.class.getResource("estilo1.css").toExternalForm());
            cambio = true;
        }

    }
}
