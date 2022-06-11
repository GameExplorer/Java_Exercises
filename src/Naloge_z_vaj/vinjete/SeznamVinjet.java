package Naloge_z_vaj.vinjete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeznamVinjet {
    private Vinjeta[] prodaneVinjete = new Vinjeta[0]; // tabela, v kateri hranimo podatke o vinjetah

    /**
     * Prebere podatke o vinjetah iz podane datoteke.
     *
     * @param vir pot do datoteke z zapisi vinjet
     * @return true, če je branje uspešno; false v primeru napake (premalo podatkov v datoteki)
     * @throws FileNotFoundException če podana datoteka ne obstaja
     */
    public boolean preberiPodatke(String vir) throws FileNotFoundException {
        Scanner vhod = new Scanner(new File(vir));
        int steviloPodatkov = 0;
        if (vhod.hasNextLine())
            steviloPodatkov = Integer.parseInt(vhod.nextLine());
        prodaneVinjete = new Vinjeta[steviloPodatkov];
        int i = 0;
        while (vhod.hasNextLine() && i < steviloPodatkov) {
            String[] pod = vhod.nextLine().split(";");
            prodaneVinjete[i++] = new Vinjeta(pod[0], pod[1], pod[2], pod[3]);
        }
        vhod.close();
        if (steviloPodatkov == 0 || i < steviloPodatkov)
            return false;
        return true;
    }

    /**
     * Izpiše vse vinjete.
     */
    public void izpisiVinjete() {
        System.out.printf("V sistemu so zabeležene prodane vinjete (%d):%n", prodaneVinjete.length);
        for (int i = 0; i < prodaneVinjete.length; i++) {
            System.out.println(prodaneVinjete[i].toString());
        }
    }

    /**
     * Preveri, ali je vozilo s podano registrsko oznako na seznamu prodanih vinjet.
     *
     * @param registrska oznaka vozila, za katerega preverjamo vinjeto
     * @return true, če je podana registrska na seznamu vinjet, sicer false
     */
    public boolean preveriVinjeto(String registrska) {
        for (int i = 0; i < prodaneVinjete.length; i++) {
            if (prodaneVinjete[i].getRegistrska().equals(registrska))
                return true;
        }
        return false;
    }

    /**
     * Izpiše vse vinjete podane vrste (letna, polletna, mesečna ali tedenska).
     *
     * @param vrsta katere vinjete izpisujemo, možnosti so: "letna", "polletna", "mesecna" ali "tedenska"
     */
    public void izpisiVinjete(String vrsta) {
        System.out.printf("V sistemu je %s vinjeta za naslednja vozila:%n", vrsta);
        int n = 0;
        for (int i = 0; i < prodaneVinjete.length; i++) {
            if (prodaneVinjete[i].getVrsta().equals(vrsta)) {
                System.out.println(prodaneVinjete[i].toString());
                n++;
            }
        }
        if (n > 0) {
            System.out.printf("Skupaj %s vinjeta: %d%n", vrsta, n);
        } else {
            System.out.printf("Nobena vinjeta ni %s.%n", vrsta);
        }
    }

    /**
     * Izpiše vse registracije, ki imajo letno vinjeto, in datum, do katerega je vinjeta veljavna.
     * Letna vinjeta je veljavna eno leto od začetka veljavnosti.
     */
    public void izpisiLetneVeljavnost() {
        System.out.println("Letne vinjete z datumi veljavnosti:");
        for (int i = 0; i < prodaneVinjete.length; i++) {
            if (prodaneVinjete[i].getVrsta().equals("letna")) {
                String datum = prodaneVinjete[i].getZacetniDatum();
                int letoVeljavnosti = Integer.parseInt(datum.substring(6)) + 1;
                String datumVeljavnosti = String.format("%s%4d", datum.substring(0, 6), letoVeljavnosti);
                System.out.printf("%s: veljavna do %s%n", prodaneVinjete[i].getRegistrska(), datumVeljavnosti);
            }
        }
    }

    /**
     * Izpiše statistiko prodanih vinjet: za vsak vinjetni razred posebej izpiše,
     * katere vrste vinjet (letne, polletne, mesečne ali tedenske) je bilo največ prodanih.
     */
    public void statistika() {
        String[] razred = {"1", "2A", "2B"};
        String[] vrsteVinjet = {"letna", "polletna", "mesecna", "tedenska"};
        System.out.println("Največ prodanih vinjet po razredih:");
        for (int i = 0; i < razred.length; i++) { // preverimo število prodanih za vsak razred posebej
            int[] steviloProdanih = new int[vrsteVinjet.length]; // vse vrednosti v tabeli so 0
            for (int j = 0; j < prodaneVinjete.length; j++) {
                if (prodaneVinjete[j].getRazred().equals(razred[i])) {
                    for (int k = 0; k < vrsteVinjet.length; k++) {
                        if (prodaneVinjete[j].getVrsta().equals(vrsteVinjet[k])) {
                            steviloProdanih[k]++;
                        }
                    }
                }
            }
            int max = Math.max(Math.max(steviloProdanih[0], steviloProdanih[1]), Math.max(steviloProdanih[2], steviloProdanih[3]));
            String vrste = "";
            for (int j = 0; j < vrsteVinjet.length; j++) {
                if (steviloProdanih[j] == max)
                    vrste += vrsteVinjet[j] + ", ";
            }
            System.out.printf("Razred %s: %d (%s)%n", razred[i], max, vrste.substring(0, vrste.length() - 2));
        }
    }
}
