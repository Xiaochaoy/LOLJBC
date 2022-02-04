package com.example.loljbc;

import com.example.loljbc.conectar.Robar;
import com.example.loljbc.conectar.RoboEstadistica;
import com.example.loljbc.modelo.Champion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    List<Champion> champions;
    public void init(){
        Robar robar = new Robar();
        //champions = robar.start();
        RoboEstadistica re = new RoboEstadistica();
        re.start(champions);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

//        champions = robar.start();
//        for (Champion c: champions) {
//            System.out.println(c.getNombre());
//        }
        launch();
    }
}