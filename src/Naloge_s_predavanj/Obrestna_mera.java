package Naloge_s_predavanj;

public class Obrestna_mera {
    public static void main(String[] args) {
        double glavnica;      // deklaracija spremenljivke
        glavnica = 1000;      // inicializacija spremenljivke

        double obrestnaMera = 4.5;  // deklaracija + inicializacija

        int n = 10; // stevilo let

        double gN; // glavnica po n letih

        /*
           Za izracun potence uporabim metodo pow().
           Ker je metoda definirana v razredu Math,
           je treba pri klicu podati tudi ime razreda,
           takole: rezultat = Math.pow(x, n).
        */
        gN = glavnica * Math.pow(1 + obrestnaMera / 100, n);

        // pri izpisu lahko "sestevam" niz in stevilo
        System.out.println("Glavnica: " + glavnica);
        System.out.println("Število let: " + n);
        System.out.println("Obrestna mera: " + obrestnaMera);
        System.out.println("Končni znesek: " + gN);
    }

}
