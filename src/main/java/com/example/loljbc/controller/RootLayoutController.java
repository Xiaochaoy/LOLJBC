package com.example.loljbc.controller;

import com.example.loljbc.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class RootLayoutController {

    // variables
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

    // cuando clique que salga de programa
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    // cuando clique que muestre info de l'aplicacion
    @FXML
    private void handleAbout() {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("LOL");
        a.setHeaderText("About");
        a.setContentText("Author: Xiaochao Ying");
        a.show();
    }

    // cuando clique que muestre la grafica
    @FXML
    private void handleShowStatistics() {
        main.showStatistics();
    }

    // cuando clique que comienze a robar info
    @FXML
    private void handleStartRobo(){
        main.startRobo();
    }

    // cuando clique que cambie el estilo y si vuelve a clicar volvera el estilo
    @FXML
    private void handleCambiEstilo(){
        TabPane tabPane = main.pillarTabPane();
        if (cambio){
            // borrar los ficheros css aginados.
            tabPane.getStylesheets().clear();
            borderPane.getStylesheets().clear();
            // asignarles otro fichero
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
