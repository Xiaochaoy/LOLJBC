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

    // llamar a la clase csv
    CSV csv = new CSV();
    // pantalla principal
    private Stage primaryStage;
    // pantalla de los menus
    private BorderPane rootLayout;
    // lista de datos de campeones
    private ObservableList<ChampionFXML> campeonData = FXCollections.observableArrayList();

    // cantidad que hay en cada rol
    public static int[] stats;

    // lista de datos de campeones con el rol de Luchador
    private ObservableList<ChampionFXML> campeonDataLu = FXCollections.observableArrayList();
    // lista de datos de campeones con el rol de Tirador
    private ObservableList<ChampionFXML> campeonDataTi = FXCollections.observableArrayList();
    // lista de datos de campeones con el rol de Apoyo
    private ObservableList<ChampionFXML> campeonDataAp = FXCollections.observableArrayList();
    // lista de datos de campeones con el rol de Mago
    private ObservableList<ChampionFXML> campeonDataMa = FXCollections.observableArrayList();
    // lista de datos de campeones con el rol de Asesino
    private ObservableList<ChampionFXML> campeonDataAs = FXCollections.observableArrayList();
    // lista de datos de campeones con el rol de Tanque
    private ObservableList<ChampionFXML> campeonDataTa = FXCollections.observableArrayList();
    // lista de datos de campeones leido por csv
    private List<String[]> champions;

    public Main() {
        // crear un variable del fichero csv
        File file = new File("lol.csv");
        try {
            //leer todos lo que hay en el fichero csv y meterlos en la lista
            champions = csv.readAll();
            // Digo que el Stats tiene un tamaño de 6
            stats = new int[6];
        } catch (Exception e) {
            e.printStackTrace();
        }
        // si el fichero existe me hace que, por la lista que hemos leido en el csv, filtramos por rol, campeones que tengan un rol que vaya a una lista de datos
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
            // poner el tamaño de cada hueco del stats
            stats[0] = campeonDataLu.size();
            stats[1] = campeonDataMa.size();
            stats[2] = campeonDataAs.size();
            stats[3] = campeonDataTi.size();
            stats[4] = campeonDataTa.size();
            stats[5] = campeonDataAp.size();
        }else {
            // si no existe que me comienze la robada de infos en la web
            startRobo();
        }
    }

    // los getter para pillar las listas
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
    // getter para pillar un array de int que estan la cantidad de cada rol
    public static int[] getStats (){ return stats;}

    // Al encender l'aplicacio
    @Override
    public void start(Stage primaryStage) {
        // pillar la primera pantalla
        this.primaryStage = primaryStage;
        // poner el nombre de LOL a l'aplicacio
        this.primaryStage.setTitle("LOL");

        // llamar a metodos
        initRootLayout();
        showCampeon();
    }

    // iniciar el RootLayout
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

            // decir que pantalla es la principal y poner de un tamaño fijo
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
    // Mostrar los campeones
    public void showCampeon() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("campeones.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            CampeonController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // para pillar el tabpane del fichero campeones.fxml
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

    // mostrar las Statistics
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

    // el robo de info
    public void startRobo(){
        Robar robar = new Robar();
        robar.start();
    }

    // getter para pillar la pantalla principal
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    // el inicio de l'aplicion
    public static void main(String[] args) {
        launch();
    }
}