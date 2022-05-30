package kviz4;

public class kviz4 {
    public static void main(String[] args) {
        preberiRacunInIzpisi("/assets/racun.txt");
    }
    static void preberiRacunInIzpisi(String imeDatoteke) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(imeDatoteke));
            double skupajBrezDDV = 0;
            double skupajDDV = 0;
            while (scanner.hasNextLine()) {
                String[] vrstica = scanner.nextLine().split("\t");
                if (vrstica.length == 3) {
                    double DDV = Double.parseDouble(vrstica[1].replace(",", "."));
                    double znesek = Double.parseDouble(vrstica[2].replace(",", "."));
                    skupajDDV += DDV;
                    skupajBrezDDV += znesek - DDV;
                }
            }
            scanner.close();
            System.out.printf("Skupaj brez DDV: %6.2f", skupajBrezDDV);
            System.out.println();
            System.out.printf("DDV:             %6.2f", skupajDDV);
            System.out.println();
            System.out.printf("ZNESEK SKUPAJ:   %6.2f", skupajBrezDDV + skupajDDV);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Napaka pri branju datoteke!");
        }
    }
    /*
    Ko je Miha pregledoval račune za obnovo hiše, je ugotovil, da mu del računa, kjer je napisan skupni znesek, manjka. Pomagaj Mihu izračunati, koliko je plačal v gradbeni trgovini.

Natančneje: napiši metodo

  void preberiRacunInIzpisi(String imeDatoteke),

ki prejme ime datoteke, v kateri je shranjen del računa, in izračuna ter izpiše skupni neto in bruto znesek ter višino davka. Pravilni izhod za datoteko racun.txt  je sledeč:



Skupaj brez DDV:  19.10

DDV:               4.20

ZNESEK SKUPAJ:    23.30



Opomba: račun vsebuje veliko podatkov, za vaš program bodo zanimive le tiste vrstice, ki vsebujejo tri podatke, ločene s tabulatorjem (opis artikla, DDV in znesek z DDV-jem). Ostale vrstice lahko ignoritate.
     */
}
