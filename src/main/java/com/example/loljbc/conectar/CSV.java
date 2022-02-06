package com.example.loljbc.conectar;

import com.example.loljbc.modelo.Champion;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase que sirve para crear fichero CSV con los datos que sacamos en la clase Webscapping
 */
public class CSV {
    File file = new File("lol.csv");

    /**
     * Esto es el metodo que recibe un parametro y lo mete en CSV.
     * @param champions recibe un lista de objetos de champion
     */
    public CSV(List<Champion> champions) {
        CSVWriter csvWriter;
        List<String[]> data = new ArrayList<>();
        for (Champion c: champions){
            data.add(new String[] {c.getNombre(),c.getRol(),c.getHistoria()});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CSV() {
    }

    public List<String[]> readAll() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get("lol.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();

        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    public List<String[]> readAll2() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get("Estadisticas.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();

        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}
