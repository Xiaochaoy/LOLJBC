package com.example.loljbc.conectar;

import com.example.loljbc.modelo.Campeon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.MalformedInputException;

public class Conectar {
    public Campeon getWeather() {
        Campeon weatherMap = null;

        try {
            weatherMap = new ObjectMapper().readValue("C:\\Users\\chaos\\IdeaProjects\\2nDAM\\LoLJBC\\src\\main\\java\\com\\example\\loljbc\\champion.json", Campeon.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return weatherMap;
    }
}
