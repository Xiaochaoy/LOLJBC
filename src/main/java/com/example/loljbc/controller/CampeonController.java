package com.example.loljbc.controller;

import com.example.loljbc.Main;
import com.example.loljbc.modelo.ChampionFXML;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CampeonController {
    @FXML
    private TableView<ChampionFXML> lolTable;
    @FXML
    private TableView<ChampionFXML> lolTableLu;
    @FXML
    private TableView<ChampionFXML> lolTableMa;
    @FXML
    private TableView<ChampionFXML> lolTableAp;
    @FXML
    private TableView<ChampionFXML> lolTableAs;
    @FXML
    private TableView<ChampionFXML> lolTableTi;
    @FXML
    private TableView<ChampionFXML> lolTableTa;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn2;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn3;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn4;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn5;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn6;
    @FXML
    private TableColumn<ChampionFXML, String> nombreColumn1;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn1;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn2;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn3;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn4;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn5;
    @FXML
    private TableColumn<ChampionFXML, String> rolColumn6;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn1;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn2;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn3;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn4;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn5;
    @FXML
    private TableColumn<ChampionFXML, String> historiaColumn6;

    @FXML
    private Label nombre;
    @FXML
    private Label rol;
    @FXML
    private Label historia;

    private Main main;

    public CampeonController() {
    }

    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        lolTable.setItems(main.getCampeonData());
        lolTableAp.setItems(main.getCampeonDataAp());
        lolTableAs.setItems(main.getCampeonDataAs());
        lolTableLu.setItems(main.getCampeonDataLu());
        lolTableMa.setItems(main.getCampeonDataMa());
        lolTableTi.setItems(main.getCampeonDataTi());
        lolTableTa.setItems(main.getCampeonDataTa());
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn1.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn2.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn3.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn4.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn5.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn6.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

        rolColumn.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn1.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn2.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn3.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn4.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn5.setCellValueFactory(cellData -> cellData.getValue().rolProperty());
        rolColumn6.setCellValueFactory(cellData -> cellData.getValue().rolProperty());

        historiaColumn.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn1.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn2.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn3.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn4.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn5.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());
        historiaColumn6.setCellValueFactory(cellData -> cellData.getValue().historiaProperty());

    }
}