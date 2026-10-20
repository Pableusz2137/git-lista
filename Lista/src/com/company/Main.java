package com.company;

public class Main {

    public static void main(String[] args) {
	System.out.println("Pawel P");
	int numerek = 1;
	int numer_2 = 2;
	System.out.println(numerek + " " + numer_2);
	Samochod samochod = new Samochod("fiat", "punto", 2005, 200);
	samochod.pokazInfo("fiat", 2005, 200);

    }
}
