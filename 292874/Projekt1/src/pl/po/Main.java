package pl.po;

public class Main {
    public static void main(String[] args) {

        Konto konto1 = new Konto("Anna Kowalska", 1000);
        Konto konto2 = new Konto("Jan Nowak");
        Konto konto3 = new Konto("   ", -50); // spacja w imieniu, ujemne saldo zamienione na 0


        System.out.println(konto1);
        System.out.println(konto2);
        System.out.println(konto3);

      
        wyswietlWynikOperacji(konto2.wplac(200), "Wpłata 200 na konto nr 2");
        wyswietlWynikOperacji(konto1.wyplac(300), "Wypłata 300 z konta nr 1");
        wyswietlWynikOperacji(konto2.wyplac(500), "Wypłata 500 z konta nr 2");
        wyswietlWynikOperacji(konto2.wplac(-50), "Wpłata -50 na konto nr 2");
        wyswietlWynikOperacji(konto1.wplac(5000), "Wpłata 5000 na konto nr 1");
        wyswietlWynikOperacji(konto1.wyplac(6000), "Wypłata 6000 z konta nr 1");
        wyswietlWynikOperacji(konto1.wyplac(5000), "Wypłata 5000 z konta nr 1");


        System.out.println("\n" + konto1);
        System.out.println(konto2);
        System.out.println(konto3);
        System.out.println("Liczba kont: " + Konto.getLiczbakont());

        if (konto1.maWiecejNiz(konto2)) {
            System.out.println("Konto nr 1 ma więcej niż konto nr 2: TAK");
        } else {
            System.out.println("Konto nr 1 ma więcej niż konto nr 2: NIE");
        }
    }


    private static void wyswietlWynikOperacji(boolean sukces, String komunikat) {
        if (sukces) {
            System.out.println(komunikat + ": OK");
        } else {
            System.out.println(komunikat + ": ODMOWA");
        }
    }
}