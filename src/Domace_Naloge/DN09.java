package Domace_Naloge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Planet {
    private String ime;
    private int radij;

    Planet() {}

    // konstruktor z omeba parametroma
    public Planet(String ime, int radij) {
        this.ime = ime;
        this.radij = radij;
    }

    public String getIme() {
        return ime;
    }


    double povrsina() {
        double povrsina = 4*Math.PI*radij*radij;
        return povrsina;
    }
}


/**
 *
 * @author tomaz
 */
public class DN09 {

    /**
     * Metoda prebere datoteko in vrne tabelo planetov.
     */
    static Planet[] preberiPlanete(String imeDatoteke) {
        try {
            Planet [] planeti = new Planet[8];
            int i = 0;

            // če vem, v kakšnem formatu je zakodirana vhodna datoteka, format (npr. UTF-8)
            // podam kot drugi argument pri klicu konstruktorja razreda Scanner
            Scanner sc = new Scanner(new File(imeDatoteke), "UTF-8");
            while (sc.hasNextLine()) {
                String vrstica = sc.nextLine();
                String [] deli = vrstica.split(":");

                if (deli.length == 2)
                    planeti[i++] = new Planet(deli[0], Integer.parseInt(deli[1]));

            }
            sc.close();
            return planeti;
        } catch (FileNotFoundException ex) {
            return new Planet[0];
        }
    }

    public static void main(String[] args)  {
        // za lazje testiranje na začetku napolnim tabelo args
        // args = new String[]{"viri/planeti.txt", "ZEMLJA+mars+luna"};

        Planet [] planeti = preberiPlanete(args[0]);

        String poizvedba = args[1];
        String [] deliPoizvedba = poizvedba.split("[+]");  //"Zemlja+Mars++Jupiter" -> {"Zemlja","Mars","Jupiter"}
        double vsota = 0;
        for(int k=0; k<deliPoizvedba.length; k++) { // sprehod po vseh poizvedbah
            int p = -1;
            for (int j = 0; j < planeti.length; j++) { // sprehod po vseh planetih
                if (planeti[j].getIme().equalsIgnoreCase(deliPoizvedba[k])) p=j;
                // namesto equalsIgnoreCase lahko primerjavo naredim tudi ročno takole:
                //if (planeti[j].ime.toLowerCase().equals(deliPoizvedba[k].toLowerCase())) p=j;
            }
            if (p!=-1){
                vsota += planeti[p].povrsina();
            }
        }
        System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2\n", poizvedba, vsota/1000000);
    }
}
