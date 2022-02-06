package com.example.loljbc.controller;

import com.example.loljbc.conectar.CSV;
import com.example.loljbc.modelo.ChampionFXML;
import com.example.loljbc.modelo.Estadistica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EstadisticaController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> campeonNames = FXCollections.observableArrayList();
    private List<String[]> estadisticas;
    CSV csv = new CSV();

    @FXML
    private void initialize() {

        try {
            estadisticas = csv.readAll2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String[] estadistica: estadisticas) {
            campeonNames.add(estadistica[1]);
        }
        // Assign the month names as categories for the horizontal axis.
    }

    public void setPersonData(int cantidad) {
        // Count the number of people having their birthday in a specific month.

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < cantidad; i++) {
            series.getData().add(new XYChart.Data<>(campeonNames.get(i), i));
        }

        barChart.getData().add(series);
    }
}
