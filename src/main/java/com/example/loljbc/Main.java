package com.example.loljbc;

import com.example.loljbc.conectar.CSV;
import com.example.loljbc.conectar.Robar;
import com.example.loljbc.controller.CampeonController;
import com.example.loljbc.controller.RootLayoutController;
import com.example.loljbc.modelo.ChampionFXML;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends Application {

    CSV csv = new CSV();
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<ChampionFXML> campeonData = FXCollections.observableArrayList();

    public static int[] stats;

    private ObservableList<ChampionFXML> campeonDataLu = FXCollections.observableArrayList();
    private ObservableList<ChampionFXML> campeonDataTi = FXCollections.observableArrayList();
    private ObservableList<ChampionFXML> campeonDataAp = FXCollections.observableArrayList();
    private ObservableList<ChampionFXML> campeonDataMa = FXCollections.observableArrayList();
    private ObservableList<ChampionFXML> campeonDataAs = FXCollections.observableArrayList();
    private ObservableList<ChampionFXML> campeonDataTa = FXCollections.observableArrayList();
    private List<String[]> champions;

    public Main() {
        // Add some sample data
        File file = new File("lol.csv");
        try {
            champions = csv.readAll();
            stats = new int[6];
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (file.exists()){
            for (String[] campeon: champions) {
                campeonData.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));
                if (campeon[1].equals("LUCHADOR")){
                    campeonDataLu.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }else if (campeon[1].equals("MAGO")){
                    campeonDataMa.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }else if (campeon[1].equals("ASESINO")){
                    campeonDataAs.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }else if (campeon[1].equals("TIRADOR")){
                    campeonDataTi.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }else if (campeon[1].equals("TANQUE")){
                    campeonDataTa.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }else if (campeon[1].equals("APOYO")){
                    campeonDataAp.add(new ChampionFXML(campeon[0], campeon[1],campeon[2]));

                }
            }
            stats[0] = campeonDataLu.size();
            stats[1] = campeonDataMa.size();
            stats[2] = campeonDataAs.size();
            stats[3] = campeonDataTi.size();
            stats[4] = campeonDataTa.size();
            stats[5] = campeonDataAp.size();
        }else {
            startRobo();
        }
    }

    public ObservableList<ChampionFXML> getCampeonData() {
        return campeonData;
    }
    public ObservableList<ChampionFXML> getCampeonDataLu() {
        return campeonDataLu;
    }
    public ObservableList<ChampionFXML> getCampeonDataMa() {
        return campeonDataMa;
    }
    public ObservableList<ChampionFXML> getCampeonDataAp() {
        return campeonDataAp;
    }
    public ObservableList<ChampionFXML> getCampeonDataAs() {
        return campeonDataAs;
    }
    public ObservableList<ChampionFXML> getCampeonDataTi() {
        return campeonDataTi;
    }
    public ObservableList<ChampionFXML> getCampeonDataTa() {
        return campeonDataTa;
    }
    public static int[] getStats (){ return stats;}

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("LOL");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            primaryStage.setScene(scene);
            primaryStage.setMaxHeight(364);
            primaryStage.setMaxWidth(616);
            primaryStage.setMinHeight(364);
            primaryStage.setMinWidth(616);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("campeones.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
//            personOverview.setMaxHeight(rootLayout.getHeight());
//            personOverview.setMaxWidth(rootLayout.getWidth());

            CampeonController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TabPane pillarTabPane(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("campeones.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            CampeonController controller = loader.getController();
            controller.setMain(this);
            return controller.getTabPane();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("estadisticas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("LoL stats");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startRobo(){
        Robar robar = new Robar();
        robar.start();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
        launch();
    }
}