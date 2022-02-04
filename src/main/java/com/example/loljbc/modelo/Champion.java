package com.example.loljbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Champion {

    String nombre;
    String rol;
    String historia;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public float getAs() {
        return as;
    }

    public void setAs(float as) {
        this.as = as;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMr() {
        return mr;
    }

    public void setMr(int mr) {
        this.mr = mr;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    int hp;
    int mp;
    int ad;
    float as;
    int ar;
    int mr;
    int ms;
    int range;


    /**
     * Esto para pillar historia.
     * @return devuelve la historia.
     */
    public String getHistoria() {
        return historia;
    }

    /**
     * Esto para asignar una historia.
     * @param historia recibe el que le vas a poner a la historia.
     */
    public void setHistoria(String historia) {
        this.historia = historia;
    }

    /**
     * Esto para pillar nombre.
     * @return devuelve el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Esto para asignar un nombre.
     * @param nombre recibe el que le vas a poner al nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Esto para pillar el rol.
     * @return devuelve el rol.
     */
    public String getRol() {
        return rol;
    }

    /**
     * ESto para asignar un rol.
     * @param rol recibe el que le vas a poner al rol.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Es un constructor que recibira unos valores y les asignara.
     * @param nombre recibe el nombre que le vas a poner.
     * @param rol recibe el rol que le vas a poner.
     * @param historia recibe la historia que le vas a poner.
     */
    public Champion(String nombre, String rol, String historia){
        this.nombre = nombre;
        this.rol = rol;
        this.historia = historia;
    }
}