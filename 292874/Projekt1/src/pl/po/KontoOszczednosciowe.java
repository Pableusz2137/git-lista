package pl.po;

public class KontoOszczednosciowe extends Konto {
    private float oprocentowanie;
    public static final int LIMIT_WYPLAT = 2;
    private int liczbaWyplat = 0;

    public KontoOszczednosciowe(String wlasciciel, float oprocentowanie) {
        this(wlasciciel, 0, oprocentowanie);
    }

    public KontoOszczednosciowe(String wlasciciel, float saldoPoczatkowe, float oprocentowanie) {
        super(wlasciciel, saldoPoczatkowe);
        setOprocentowanie(oprocentowanie);
    }

    private void setOprocentowanie(float oprocentowanie) {
        if (oprocentowanie < 0 || oprocentowanie > 0.10f) {
            this.oprocentowanie = 0;
        } else {
            this.oprocentowanie = oprocentowanie;
        }
    }

    public float getOprocentowanie() {
        return oprocentowanie;
    }

    public int getLiczbaWyplat() {
        return liczbaWyplat;
    }

    public void naliczOdsetki() {
        if (getSaldo() > 0) {
            float odsetki = getSaldo() * oprocentowanie;
            ustawSaldo(getSaldo() + odsetki);
        }
    }

    @Override
    public boolean czyMozewyplacic(float kwota) {
        return liczbaWyplat < LIMIT_WYPLAT && super.czyMozewyplacic(kwota);
    }

    @Override
    public boolean wyplac(float kwota) {
        boolean sukces = super.wyplac(kwota);
        if (sukces) {
            liczbaWyplat++;
        }
        return sukces;
    }

    @Override
    public String toString() {
        String procStr = String.format("%.2f", oprocentowanie * 100).replace(',', '.') + "%";
        return super.toString() + " | oszczędnościowe " + procStr + ", wypłaty: " + liczbaWyplat + "/" + LIMIT_WYPLAT;
    }
}