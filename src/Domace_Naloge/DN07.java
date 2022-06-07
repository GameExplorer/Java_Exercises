package Domace_Naloge;

import java.util.Random;
public class DN07 {
    static String[] prva   = {"Miha", "Micka", "Tone", "Lojze", "Mojca", "Pepca", "Franci", "Francka"};
    static String[] druga  = {"Vozi", "Seka", "Potrebuje", "Gleda", "Barva", "Voha", "Lomi", "Popravlja"};
    static String[] tretja = {"Kolo", "Avto", "Likalnik", "Sonce", "Vrtnico", "Drevo", "Lopato", "Sekiro"};

    static String ustvariGeslo() {
        Random rnd = new Random();
        int rnd1 = rnd.nextInt(prva.length);
        int rnd2 = rnd.nextInt(druga.length);
        int rnd3 = rnd.nextInt(tretja.length);

        return prva[rnd1] + druga[rnd2] + tretja[rnd3];
    }
    
    // metoda vrne true, če tabela "besede" vsebuje besedo "beseda"
    static boolean tabelaVsebuje(String beseda, String[] besede) {
        for (int i = 0; i < besede.length; i++) {
            if (besede[i].equals(beseda)) return true;
        }
        return false;
    }
    static boolean lahkoUstvari(String geslo) {
        // dani niz razbijem na besede tako, da pred vse velike črke dodam presledek,
        // nato preoblikovano geslo razbijem s split(" ")
        String[] besede = geslo.replaceAll("([A-Z])", " $1").trim().split(" ");

        return (besede.length == 3) && (tabelaVsebuje(besede[0], prva)) &&
                (tabelaVsebuje(besede[1], druga))&& (tabelaVsebuje(besede[2], tretja));
    }
    public static void main(String[] args) {
        System.out.println(lahkoUstvari(args[0]));
    }
}