package pl.po;

public class Konto {
    private static int liczbakont = 0;

    private final int numer;
    private final String wlasciciel;
    private float saldo;
    private int liczbaOperacji;


    public static final float MAKS_WYPLATA = 5000;



    public Konto(String wlasciciel) {
        liczbakont++;
        this.numer = liczbakont;
        this.saldo = 0;
        this.liczbaOperacji = 0;


        if (wlasciciel == null || wlasciciel.trim().isEmpty()) {
            this.wlasciciel = "nieznany";
        } else {
            this.wlasciciel = wlasciciel;
        }
    }


    public Konto(String wlasciciel, float saldoPoczatkowe) {
        this(wlasciciel);
        if (saldoPoczatkowe < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldoPoczatkowe;
        }

    }


    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getLiczbaOperacji() {
        return liczbaOperacji;
    }

    public static int getLiczbakont() {
        return liczbakont;
    }




    public boolean wplac(float kwota) {
        if (kwota <= 0) {
            return false;
        }
        saldo += kwota;
        liczbaOperacji++;
        return true;
    }

    public boolean czyMozewyplacic(float kwota) {
        return kwota > 0 && kwota <= saldo && kwota <= MAKS_WYPLATA;
    }

    public boolean wyplac(float kwota) {
        if (!czyMozewyplacic(kwota)) {
            return false;
        }
        saldo -= kwota;
        liczbaOperacji++;
        return true;
    }

    public boolean maWiecejNiz(Konto inneKonto) {
        return this.saldo > inneKonto.getSaldo();
    }

    @Override
    public String toString() {
        return "Konto nr " + numer + " [" + wlasciciel + "] saldo: " + saldo + " | operacji: " + liczbaOperacji;
    }
}