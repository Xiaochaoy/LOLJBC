package com.example.loljbc.modelo;

public class Estadistica {
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

    public Estadistica(String nom, int hp, int mp, int ad, float as, int ar, int mr, int ms, int range) {
        this.nom = nom;
        this.hp = hp;
        this.mp = mp;
        this.ad = ad;
        this.as = as;
        this.ar = ar;
        this.mr = mr;
        this.ms = ms;
        this.range = range;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    String nom;
    int hp;
    int mp;
    int ad;
    float as;
    int ar;
    int mr;
    int ms;
    int range;

}
