package com.example.loljbc.controller;

import com.example.loljbc.Main;
import com.example.loljbc.conectar.CSV;
import com.example.loljbc.modelo.ChampionFXML;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class EstadisticaController implements Initializable {

    // la grafica que tengo
    @FXML
    private PieChart pieChart;

    int[] stats;


    // cuando inicialize meto los datos en la grafica
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stats = Main.getStats();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                // poner el nombre y un valor
                new PieChart.Data("LUCHADOR",stats[0]),
                new PieChart.Data("MAGO",stats[1]),
                new PieChart.Data("ASESINO",stats[2]),
                new PieChart.Data("TIRADOR",stats[3]),
                new PieChart.Data("TANQUE",stats[4]),
                new PieChart.Data("APOYO",stats[5]));

        // esto para que me muestra de tal forma
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", (int) data.getPieValue()
                        )
                ));
        // meter en la grafica
        pieChart.getData().addAll(pieChartData);
    }
}
