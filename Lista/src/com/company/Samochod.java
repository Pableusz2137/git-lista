package com.company;

public class Samochod {
    private String marka;
    private String model;
    private int rok;
    private int predkosc;

    Samochod(String marka, String model, int rok, int predkosc) {
        this.marka = marka;
        this.model = model;
        this.rok = rok;
        this.predkosc = 0;

    }
    static void pokazInfo(String marka, int predkosc, int wartosc) {
        if (predkosc > 0) {
            System.out.println("Marka = " + marka + " predkosc " + predkosc + " km/h" + " przyspiesz " + wartosc + "hamowanie" + wartosc);
        } else {
            System.out.println("blad");
        }
    }
}
