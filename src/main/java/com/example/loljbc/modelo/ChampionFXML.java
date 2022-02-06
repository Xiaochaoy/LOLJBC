package com.example.loljbc.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class ChampionFXML {

    private final StringProperty nombre;
    private final StringProperty rol;
    private final StringProperty historia;


    public StringProperty nombreProperty() {
        return nombre;
    }
    public StringProperty rolProperty() {
        return rol;
    }
    public StringProperty historiaProperty() {
        return historia;
    }

    /**
     * Esto para pillar historia.
     * @return devuelve la historia.
     */
    public String getHistoria() {
        return historia.get();
    }

    /**
     * Esto para asignar una historia.
     * @param historia recibe el que le vas a poner a la historia.
     */
    public void setHistoria(String historia) {
        this.historia.set(historia);
    }

    /**
     * Esto para pillar nombre.
     * @return devuelve el nombre
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * Esto para asignar un nombre.
     * @param nombre recibe el que le vas a poner al nombre.
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * Esto para pillar el rol.
     * @return devuelve el rol.
     */
    public String getRol() {
        return rol.get();
    }

    /**
     * ESto para asignar un rol.
     * @param rol recibe el que le vas a poner al rol.
     */
    public void setRol(String rol) {
        this.rol.set(rol);
    }

    /**
     * Es un constructor que recibira unos valores y les asignara.
     * @param nombre recibe el nombre que le vas a poner.
     * @param rol recibe el rol que le vas a poner.
     * @param historia recibe la historia que le vas a poner.
     */
    public ChampionFXML(String nombre, String rol, String historia){
        this.nombre = new SimpleStringProperty(nombre);
        this.rol = new SimpleStringProperty(rol);
        this.historia = new SimpleStringProperty(historia);
    }
}