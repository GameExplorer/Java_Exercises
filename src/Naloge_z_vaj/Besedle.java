package Naloge_z_vaj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Besedle {

    // Barve
    static int BELA = 0;
    static int CRNA = 1;
    static int RUMENA = 2;
    static int ZELENA = 3;

    // ANSI ukazi
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN_BG = "\u001b[42m";
    static final String ANSI_YELLOW_BG = "\u001b[43m";
    static final String ANSI_WHITE_BG = "\u001b[47;1m";
    static final String ANSI_BLACK_BG = "\u001b[40m";
    static final String ANSI_WHITE = "\u001b[37m";
    static final String ANSI_BLACK = "\u001b[30m";

    // Veljavne črke
    static final String abeceda = "ABCČDEFGHIJKLMNOPRSŠTUVZŽ";
    static final int MAX_POSKUSOV = 6; // Število poskusov

    static String[] seznamBesed; // Seznam možnih besed za igro
    static String[] slovar; // Seznam vseh veljavnih besed

    static String iskanaBeseda; // Iskana beseda trenutne igre
    static int[] barveAbecede; // Barve črk v abecedi za trenutno igro

    static Random rnd = new Random();
    static Scanner sc = new Scanner(System.in);

    // Izpiše znak v izbrani barvi
    static void izpisiZBarvo(char znak, int barva){
        String slog;
        if(barva == ZELENA){
            slog = ANSI_BLACK + ANSI_GREEN_BG;
        } else if (barva == RUMENA){
            slog = ANSI_BLACK + ANSI_YELLOW_BG;
        } else if (barva == BELA){
            slog = ANSI_BLACK + ANSI_WHITE_BG;
        } else {
            slog = ANSI_WHITE + ANSI_BLACK_BG;
        }
        System.out.print(slog + " " + znak + " " + ANSI_RESET);
    }

    // Prebere seznam besed iz datoteke
    static void preberiBesede(String datoteka) throws FileNotFoundException {
        File f = new File(datoteka);
        Scanner sc = new Scanner(f);

        // Stevilo besed
        int stBesed = sc.nextInt();
        sc.nextLine();

        // Seznam besed
        seznamBesed = new String[stBesed];
        for (int i = 0; i < stBesed; i++) {
            seznamBesed[i] = sc.nextLine().toUpperCase();
        }
    }

    // Pripravi vse za novo igro
    static void novaIgra(){
        // Naključna beseda
        int idx = rnd.nextInt(seznamBesed.length);
        iskanaBeseda = seznamBesed[idx];

        // Barve abecede na 0 (BELA = 0)
        barveAbecede = new int[abeceda.length()];
    }

    // Izpiši abecedo
    static void izpisiAbecedo(){
        System.out.println();
        System.out.print("Preostale črke: ");
        for(int i=0; i<abeceda.length(); i++){
            izpisiZBarvo(abeceda.charAt(i), barveAbecede[i]);
        }
        System.out.println();
    }

    // Ali je beseda veljavna?
    static boolean veljavnaBeseda(String beseda){
        // Ali je dolžina pravilna?
        if (beseda.length() != 5){
            System.out.println("Nepravilna dolžina besede!");
            return false;
        }

        // Ali so vsi znaki veljavni?
        for(int i=0; i<beseda.length(); i++){
            if (abeceda.indexOf(beseda.charAt(i)) == -1){
                System.out.println("V besedi so neveljavni znaki!");
                return false;
            }
        }

        // Dodatna naloga: beseda v slovarju?
        if(!besedaVSlovarju(beseda)) {
            System.out.println("Besede ni v slovarju!");
            return false;
        }

        return true;
    }

    // Pobarva črke v ugibani besedi (osnovna pravila)
    static int[] pobarvajBesedo(String ugibanaBeseda){
        int[] barve = new int[5];
        for(int i=0; i<ugibanaBeseda.length(); i++){
            char crka = ugibanaBeseda.charAt(i);
            int iCrke = abeceda.indexOf(crka);
            if(crka == iskanaBeseda.charAt(i)){
                // Pravilna črka
                barve[i] = ZELENA;
                barveAbecede[iCrke] = ZELENA;
            } else if (iskanaBeseda.indexOf(ugibanaBeseda.charAt(i)) != -1) {
                // Črka na napačnem mestu
                barve[i] = RUMENA;
                barveAbecede[iCrke] = Math.max(barveAbecede[iCrke], RUMENA); // ZELENA > RUMENA
            } else {
                // Napačna črka
                barve[i] = BELA;
                barveAbecede[iCrke] = CRNA;
            }
        }
        return barve;
    }

    // Izpiši besedo
    static void izpisiBesedo(String ugibanaBeseda, int[] barve){
        for(int i=0; i<ugibanaBeseda.length(); i++){
            izpisiZBarvo(ugibanaBeseda.charAt(i), barve[i]);
        }
        System.out.println();
    }

    // Prebere slovar iz datoteke
    static void preberiSlovar(String datoteka) throws FileNotFoundException {
        File f = new File(datoteka);
        Scanner sc = new Scanner(f);

        // Stevilo besed
        int stBesed = sc.nextInt();
        sc.nextLine();

        // Slovar
        slovar = new String[stBesed];
        for (int i = 0; i < stBesed; i++) {
            slovar[i] = sc.nextLine().toUpperCase();
        }
    }

    // Ali je beseda v slovarju
    static boolean besedaVSlovarju(String beseda){
        for (int i=0; i<slovar.length; i++){
            if(beseda.equals(slovar[i])){
                return true;
            }
        }
        return false;
    }

    // Pobarva črke v ugibani besedi (naprednejša pravila)
    static int[] pravilnoPobarvajBesedo(String ugibanaBeseda){
        int[] stManjkajocih = new int[abeceda.length()]; // Štetje ponovitev manjkajočih črk

        int[] barve = new int[5];
        // Označi zelene in preštej manjkajoče črtke
        for(int i = 0; i< iskanaBeseda.length(); i++){
            char crka = iskanaBeseda.charAt(i);
            int iCrke = abeceda.indexOf(crka);
            if(crka == ugibanaBeseda.charAt(i)){
                barve[i] = ZELENA;
                barveAbecede[iCrke] = ZELENA;
            } else {
                stManjkajocih[iCrke] += 1;
            }
        }
        // Pobarvaj rumene in bele
        for(int i=0; i<ugibanaBeseda.length(); i++){
            int iCrke = abeceda.indexOf(ugibanaBeseda.charAt(i));
            if(barve[i] != ZELENA) {
                if (stManjkajocih[iCrke] > 0) {
                    // Če je še dovolj manjkajočih ponovitev, jo pobarvaj rumeno
                    stManjkajocih[iCrke] -= 1;
                    barve[i] = RUMENA;
                    barveAbecede[iCrke] = Math.max(barveAbecede[iCrke], RUMENA); // ZELENA > RUMENA
                } else {
                    // Sicer belo
                    barve[i] = BELA;
                    barveAbecede[iCrke] = CRNA;
                }
            }
        }
        return barve;
    }

    // Izvede eno igro
    static void igra(){
        novaIgra();

        int poskus = 1;
        boolean uganil = false;
        while(poskus <= MAX_POSKUSOV) {
            izpisiAbecedo();
            System.out.printf("Poskus %d/6: ", poskus);
            String ugibanaBeseda = sc.nextLine().toUpperCase();

            // Preveri veljavnost
            if (!veljavnaBeseda(ugibanaBeseda))
                continue;

            // Pobarvaj crke
//            int[] barve = pobarvajBesedo(ugibanaBeseda);
            int[] barve = pravilnoPobarvajBesedo(ugibanaBeseda);

            // Izpiši besedo
            izpisiBesedo(ugibanaBeseda, barve);

            if(ugibanaBeseda.equals(iskanaBeseda)){
                uganil = true;
                break;
            }

            poskus++;
        }

        if(uganil){
            System.out.printf("Bravo! Besedo si uganil/a v %d poskusih.\n", poskus);
        } else {
            System.out.printf("Žal ti ni uspelo. Pravilna beseda: %s\n", iskanaBeseda);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        preberiBesede("src/Naloge_z_vaj/assets/besede.txt");
        preberiSlovar("src/Naloge_z_vaj/assets/slovar.txt");

        while(true) {
            // Ponavljamo igro, dokler igralec ne želi zaključiti
            igra();
            System.out.print("Nova igra? (y/n): ");
            String odg = sc.nextLine();
            if(odg.toLowerCase().charAt(0) != 'y'){
                break;
            }
        }

        sc.close();
    }
}
