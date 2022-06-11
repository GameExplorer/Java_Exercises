package Naloge_z_vaj.aplikacija;

import Naloge_z_vaj.vinjete.SeznamVinjet;

import java.io.FileNotFoundException;

public class Kontrola {
    public static void main(String[] args) throws FileNotFoundException {
        String dat = "src/Naloge_z_vaj/assets/vinjete.txt";
        String reg1 = "LJFRI113";
        String reg2 = "KRPP112";
        SeznamVinjet vinjete = new SeznamVinjet();
        // preberi podatke o vinjetah
        if (vinjete.preberiPodatke(dat)) {
            System.out.println("Podatki o vinjetah so uspešno prebrani.");
        } else {
            System.out.println("Napaka pri branju datoteke s podatki o vinjetah.");
        }
        System.out.println();
        // izpiši vse vinjete
        vinjete.izpisiVinjete();
        System.out.println();

        // preveri vinjeto za podano registracijo
        if (vinjete.preveriVinjeto(reg1))
            System.out.printf("Vozilo [%s] ima kupljeno vinjeto.%n", reg1);
        else
            System.out.printf("Vozilo [%s] nima kupljene vinjete.%n", reg1);
        if (vinjete.preveriVinjeto(reg2))
            System.out.printf("Vozilo [%s] ima kupljeno vinjeto.%n", reg2);
        else
            System.out.printf("Vozilo [%s] nima kupljene vinjete.%n", reg2);
        System.out.println();

        // izpiši letne vinjete
        vinjete.izpisiVinjete("letna");
        System.out.println();
        // izpiši polletne vinjete
        vinjete.izpisiVinjete("polletna");
        System.out.println();
        // izpiši mesečne vinjete
        vinjete.izpisiVinjete("mesecna");
        System.out.println();
        // izpiši tedenske vinjete
        vinjete.izpisiVinjete("tedenska");
        System.out.println();

        // izpiši veljavnost letnih vinjet
        vinjete.izpisiLetneVeljavnost();
        System.out.println();

        // izpiši skupno statistiko prodanih vinjet
        vinjete.statistika();
    }
}
