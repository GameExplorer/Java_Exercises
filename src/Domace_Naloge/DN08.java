package Domace_Naloge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class DN08 {
    private static final int STEVILO_SODNIKOV = 5;   // število sodnikov, ki ocenjujejo polete
    private static final int PODATKI_TEKMOVALCA = 5; // število podatkov, ki jih imamo o enem tekmovalcu
    private static final int SERIJE = 2;             // koliko serij imamo (prva in druga)
    private static final int STEVILO_2_SERIJA = 30;  // koliko tekmovalcev se uvrsti v drugo (finalno) serijo
    private static final String DISQUAL = "DSQ";     // tekmovalec je diskvalificiran

    // podatki o letalnici
    private static final int K_POINT = 200;            // K-točka letalnice
    private static final int FLYING_HILL_POINTS = 120; // število točk za doseženo K-točko
    private static final double METER_VALUE = 1.2;     // faktor za dodatne točke za vsak meter pod/nad K-točko

    // podatki o tekmovalcih
    private static String[][] tekmovalci; // podatki o posameznem tekmovalcu; prva dimenzija so tekmovalci, druga različni podatki enega tekmovalca
    private static double[][] daljave;    // daljava prve (0) in druge (1) serije; prva dimenzija so tekmovalci, druga serija
    private static double[][][] ocene;    // ocene prve (0) in druge (1) serije od vseh 5 sodnikov; prva dimenzija so tekmovalci, druga serija, tretja sodniki
    private static double[][] komp_nalet; // kompenzacijske točke za nalet v prvi (0) in drugi (1) seriji; prva dimenzija so tekmovalci, druga serija
    private static double[][] komp_veter; // kompenzacijske točke za veter v prvi (0) in drugi (1) seriji; prva dimenzija so tekmovalci, druga serija
    private static double[][] tocke;      // seštevek doseženih točk v seriji; prva dimenzija so tekmovalci, druga serija: prva (0), druga (1), obe skupaj (2)

    /* Branje podatkov iz datotek */

    // branje podatkov o tekmovalcih (startna lista prve serije)
    private static void preberiTekmovalce(String dat) throws FileNotFoundException {
        Scanner vhod = new Scanner(new File(dat));
        int steviloTekmovalcev = Integer.parseInt(vhod.nextLine());
        tekmovalci = new String[steviloTekmovalcev][PODATKI_TEKMOVALCA];
        for (int i = 0; i < steviloTekmovalcev; i++) {
            vhod.nextLine(); // preskoči prazno vrstico med tekmovalci
            for (int j = 0; j < PODATKI_TEKMOVALCA; j++) { //
                tekmovalci[i][j] = vhod.nextLine().trim();
            }
        }
        vhod.close();
        // pripravi tabele za druge podatke o rezultatih tekmovalca (na začetku so vse vrednosti v tabelah enake 0.0)
        daljave = new double[steviloTekmovalcev][SERIJE];
        ocene = new double[steviloTekmovalcev][SERIJE][STEVILO_SODNIKOV];
        komp_nalet = new double[steviloTekmovalcev][SERIJE];
        komp_veter = new double[steviloTekmovalcev][SERIJE];
        tocke = new double[steviloTekmovalcev][SERIJE + 1];
    }

    // branje podatkov o rezultatih (daljave, kompenzacijske točke za nalet in za veter) za podano serijo
    private static void preberiRezultate(int serija, String dat) throws FileNotFoundException {
        Scanner vhod = new Scanner(new File(dat));
        vhod.nextLine(); // preskoči prvo vrstico z opisi podatkov (glavo)
        while (vhod.hasNextLine()) {
            String[] deli = vhod.nextLine().split(";"); // BIB;SPEED [km/h];DISTANCE;GATE;POINTS;[m/s];POINTS
            int stevilka = Integer.parseInt(deli[0]);
            if (deli[1].equals(DISQUAL)) { // ni rezultata, ker diskvalificiran; vpiši negativne vrednosti za daljavo
                daljave[stevilka - 1][serija - 1] = -1.0;
                daljave[stevilka - 1][SERIJE - 1] = -1.0;
            } else {
                daljave[stevilka - 1][serija - 1] = Double.parseDouble(deli[2]);
                if (!deli[4].isEmpty()) {
                    komp_nalet[stevilka - 1][serija - 1] = Double.parseDouble(deli[4]);
                }
                if (deli.length > 6 && !deli[6].isEmpty()) {
                    komp_veter[stevilka - 1][serija - 1] = Double.parseDouble(deli[6]);
                }
            }
        }
        vhod.close();
    }

    // branje sodniških ocen za podano serijo
    private static void preberiOcene(int serija, String dat) throws FileNotFoundException {
        Scanner vhod = new Scanner(new File(dat));
        vhod.nextLine(); // preskoči prvo vrstico z opisi podatkov (glavo)
        while (vhod.hasNextLine()) {
            String[] deli = vhod.nextLine().split(";"); // BIB;A;B;C;D;E
            int stevilka = Integer.parseInt(deli[0]);
            if (!deli[1].equals(DISQUAL)) { // če je diskvalificiran, preskoči
                for (int i = 0; i < STEVILO_SODNIKOV; i++) {
                    ocene[stevilka - 1][serija - 1][i] = Double.parseDouble(deli[i + 1]);
                }
            }
        }
        vhod.close();
    }

    /* Izračuni na podlagi prebranih podatkov (točke, vrstni reda ...) */

    // za podano daljavo, ocene in kompenzacije izračuna doseženo število točk (za enega tekmovalca)
    private static double izracunajTockeTekmovalca(double daljava, double nalet, double veter, double[] ocene) {
        // izračunaj točke za slog: seštejemo ocene sodnikov, najboljša in najslabša ocena se ne upoštevata
        double slog = 0.0;
        double min = 20.0, max = 0.0;
        for (int i = 0; i < ocene.length; i++) {
            slog += ocene[i];
            if (ocene[i] < min)
                min = ocene[i];
            if (ocene[i] > max)
                max = ocene[i];
        }
        slog = slog - min - max;
        // izračunaj točke za daljavo, kompezacijo naleta in vetra ter slog
        return FLYING_HILL_POINTS + (daljava - K_POINT) * METER_VALUE + nalet + veter + slog;
    }

    // izračuna dosežene točke v seriji za vse tekmovalce
    private static void izracunajTocke(int serija) {
        for (int i = 0; i < tekmovalci.length; i++) {
            if (daljave[i][serija - 1] <= 0) // tekmovalec diskvalificiran ali ni nastopil, preskoči računanje točk (ima nič točk)
                continue;
            tocke[i][serija - 1] = izracunajTockeTekmovalca(daljave[i][serija - 1], komp_nalet[i][serija - 1], komp_veter[i][serija - 1], ocene[i][serija - 1]);
            // točke zapiši tudi pod skupno vsoto, ki je shranjena pod zadnjim indeksom (točke prve serije oz. vsota točk obeh serij)
            tocke[i][SERIJE] += tocke[i][serija - 1];
        }
    }

    // primerja enakost dveh double števil na eno decimalko natančno;
    // vrne true, če x == y
    private static boolean enakiVrednosti(double x, double y) {
        // zaradi nenatančnosti tipa double, da lahko primerjamo enakost
        // double spremenimo v celo število (eno decimalno mesto, zato pomnožimo z 10 in zaokrožimo)
        return (Math.round(x * 10) == Math.round(y * 10));
    }

    // primerja tekmovalca pri indeksih a in b po točkah in daljavi v seriji (prvi seriji ali skupne točke pri drugi seriji);
    // vrne true, če je a boljši od b (ima več točk oziroma daljši skok ob enakih točkah)
    private static boolean boljsi(int a, int b, int serija) {
        int indTock = (serija == SERIJE) ? SERIJE : serija - 1; // pri finalni seriji gledamo skupne točke (pri indeksu SERIJE)
        if (tocke[a][indTock] > tocke[b][indTock])
            return true;
        if (enakiVrednosti(tocke[a][indTock], tocke[b][indTock]) && daljave[a][serija - 1] > daljave[b][serija - 1])
            return true;
        return false;
    }

    // vrne tabelo indeksov tekmovalcev, ki so urejeni padajoče po številu doseženih točk v seriji
    private static int[] urediRezultate(int serija) {
        int[] tabela = new int[tekmovalci.length];
        // v tabelo zapiši indekse tekmovalcev po vrsti
        for (int i = 0; i < tekmovalci.length; i++) {
            tabela[i] = i;
        }
        // uredi tabelo glede na točke in daljave
        for (int i = 0; i < tabela.length - 1; i++) {
            for (int j = i + 1; j < tabela.length; j++) {
                if (boljsi(tabela[j], tabela[i], serija)) {
                    int tmp = tabela[i];
                    tabela[i] = tabela[j];
                    tabela[j] = tmp;
                }
            }
        }
        return tabela;
    }

    // v tabelo rank zapiše dosežena mesta; pri enakih točkah se mesto deli
    private static int[] dolociUvrstitev(int[] rez, int serija) {
        int indSerije = (serija == SERIJE) ? SERIJE : serija - 1; // pri finalni seriji gledamo skupne točke (pri indeksu SERIJE)
        int[] rank = new int[tekmovalci.length];
        int mesto = 1;
        rank[rez[0]] = mesto;  // prvo mesto ima tekmovalec z indeksom, ki je na prvem mestu v tabeli rezultatov
        int i = 1;
        while (i < rez.length) {
            while (i < rez.length && enakiVrednosti(tocke[rez[i - 1]][indSerije], tocke[rez[i]][indSerije])) { // delitev mesta
                rank[rez[i]] = mesto;
                i++;
            }
            mesto = i + 1;
            if (i < rez.length)
                rank[rez[i]] = mesto;
            i++;
        }
        return rank;
    }

    /* Izpisi podatkov na standardni izhod*/

    // izpiše vse podatke o vseh tekmovalcih (startna lista prve serije)
    private static void izpisiTekmovalce() {
        System.out.printf("Start List 1st Round:%nBIB NAME                      (NSA)  [DATE OF BIRTH, CLUB]%n");
        for (int i = 0; i < tekmovalci.length; i++) {
            System.out.printf("%3s %-25s (%3s)  [%11s, %s]%n", tekmovalci[i][0], tekmovalci[i][1], tekmovalci[i][4], tekmovalci[i][3], tekmovalci[i][2]);
        }
    }

    // izpiše vse podatke o vseh tekmovalcih in doseženih daljavah
    private static void izpisiRezultate(int serija) {
        System.out.printf("Results %s round:%nBIB NAME                      (NSA)  [DATE OF BIRTH, CLUB]", (serija == SERIJE) ? "final" : "first");
        System.out.printf("%38s%s%n", "DISTANCE [m]", (serija == SERIJE) ? "  (DISTANCE [m])" : "");
        for (int i = 0; i < tekmovalci.length; i++) {
            System.out.printf("%3s %-25s (%3s)  %-45s", tekmovalci[i][0], tekmovalci[i][1], tekmovalci[i][4], String.format("[%11s, %s]", tekmovalci[i][3], tekmovalci[i][2]));
            if (daljave[i][serija - 1] > 0) {
                System.out.printf("  %-14.1f", daljave[i][serija - 1]);
            } else {
                System.out.printf("  %-14s", (daljave[i][serija - 1] < 0) ? "Disqualified" : "Not qualified");
            }
            if (serija == SERIJE && daljave[i][0] > 0) {
                System.out.printf("(%5.1f)", daljave[i][0]);
            }
            System.out.println();
        }
    }

    // izpiše podatke o vseh tekmovalcih in doseženih točkah za serijo oz. skupaj za obe seriji
    private static void izpisiTocke(int serija) {
        System.out.printf("Points %s round:%nBIB NAME %26s  POINTS%s%n", (serija == SERIJE) ? "final" : "first", "(NSA)", (serija == SERIJE) ? " (1st)  POINTS (final)  TOTAL" : "");
        for (int i = 0; i < tekmovalci.length; i++) {
            System.out.printf("%3s %-25s (%3s)", tekmovalci[i][0], tekmovalci[i][1], tekmovalci[i][4]);
            if (daljave[i][0] < 0)
                System.out.print("  DSQ  ");
            else if (tocke[i][0] > 0)
                System.out.printf("%7.1f", tocke[i][0]);
            else
                System.out.print("    -  ");
            if (serija == SERIJE) {
                if (daljave[i][serija - 1] < 0 && daljave[i][serija - 2] > 0)
                    System.out.printf("%14s", "DSQ  ");
                else if (tocke[i][serija - 1] > 0)
                    System.out.printf("%14.1f", tocke[i][serija - 1]);
                else
                    System.out.printf("%14s", "-  ");
                if (tocke[i][serija] > 0)
                    System.out.printf("%16.1f", tocke[i][serija]);
                else
                    System.out.printf("%14s", "-");
            }
            System.out.println();
        }
    }

    // pretvori mesec v število (pomožna metoda za primerjavo dveh datumov)
    private static int vrniMesec(String mes) {
        String[] meseci = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        for (int i = 0; i < meseci.length; i++) {
            if (mes.equals(meseci[i]))
                return i + 1;
        }
        return 0;
    }

    // primerja tekmovalca z indeksom i in j po starosti
    // vrne pozitivno število, če je i mlajši od j; vrne 0, če sta enako stara; vrne negativno število, če je i starejši od j
    private static int mlajsi(int i, int j) {
        String[] datum1 = tekmovalci[i][3].split(" ");
        String[] datum2 = tekmovalci[j][3].split(" ");
        int leto1 = Integer.parseInt(datum1[2]);
        int leto2 = Integer.parseInt(datum2[2]);
        if (leto1 != leto2)
            return leto1 - leto2;
        int mesec1 = vrniMesec(datum1[1]);
        int mesec2 = vrniMesec(datum2[1]);
        if (mesec1 != mesec2)
            return mesec1 - mesec2;
        int dan1 = Integer.parseInt(datum1[0]);
        int dan2 = Integer.parseInt(datum2[0]);
        return dan1 - dan2;
    }

    // izpiše ime najmlajšega tekmovalca, ki je preskočil K-točko
    private static void izpisiNajmlajsega() {
        int[] prekoK = new int[tekmovalci.length];  // tabela indeksov vseh enako starih najmlajših preko K
        int num = 0; // koliko imamo enako starih najmlajših preko K
        // poišči prvega preko K
        int i = 0;
        while (i < tekmovalci.length && daljave[i][0] <= K_POINT && daljave[i][1] <= K_POINT) {
            i++;
        }
        if (i < tekmovalci.length) { // našli smo tekmovalca preko K
            prekoK[0] = i;
            num = 1;
        }
        // med preostalimi poišči mlajšega (ali enako starega), ki je skočil preko K
        i++;
        while (i < tekmovalci.length) {
            if (daljave[i][0] > K_POINT || daljave[i][1] > K_POINT) {
                int razlikaStarosti = mlajsi(i, prekoK[0]);
                if (razlikaStarosti > 0) {
                    prekoK[0] = i;
                    num = 1;
                } else if (razlikaStarosti == 0) {
                    prekoK[num] = i;
                    num++;
                }
            }
            i++;
        }
        if (num == 0) {
            System.out.println("All flights are below K-point.");
        } else {
            for (int j = 0; j < num; j++) {
                System.out.println(tekmovalci[prekoK[j]][1]);
            }
        }
    }

    // izpiše sodnika z najboljšim in najslabšim povprečjem dodeljenih ocen
    private static void izpisiSodnike() {
        // za vse sodnike izračunamo povprečja vseh dodeljenih ocen
        double[] povprecja = new double[STEVILO_SODNIKOV];
        int min = 0, max = 0; // indeksa sodnikov z najslabšimi in najboljšimi ocenami
        for (int i = 0; i < povprecja.length; i++) {
            int n = 0; // koliko ocen je podelil sodnik
            double vsota = 0.0; // vsota vseh ocen sodnika
            for (int j = 0; j < tekmovalci.length; j++) {
                for (int k = 0; k < SERIJE; k++) {
                    if (ocene[j][k][i] > 0) { // tekmovalci, ki niso nastopili ali so diskvalificirani, imajo oceno 0
                        vsota += ocene[j][k][i];
                        n++;
                    }
                }
            }
            povprecja[i] = vsota / n;
            if (povprecja[i] < povprecja[min])
                min = i;
            if (povprecja[i] > povprecja[max])
                max = i;
        }
        System.out.printf("Best marks:  %c (%.1f)%nWorst marks: %c (%.1f)%n", 'A' + max, povprecja[max], 'A' + min, povprecja[min]);
    }

    /* Izpisi podatkov v izhodno datoteko */

    // v podano datoteko zapiše startno listo za finalno serijo
    private static void shraniStartnoListo(int[] rezultati, int[] uvrstitev, String dat) throws FileNotFoundException {
        PrintWriter izhod = new PrintWriter(dat);
        izhod.println("START ORD.;BIB;NAME;NSA;POINTS;RANK;BEHIND POINTS");
        // na startni listi so tekmovalci od 30. mesta do 1. mesta
        int num = Math.min(rezultati.length, STEVILO_2_SERIJA) - 1;
        while (tocke[rezultati[num]][0] <= 0) // izpusti tekmovalce, ki nimajo točk (niso dosegli rezultata)
            num--;
        for (int i = num; i >= 0; i--) {
            int indeks = rezultati[i];
            izhod.printf("%d;%s;%s;%s;%.1f;%d;%.1f%n", num - i + 1, tekmovalci[indeks][0], tekmovalci[indeks][1], tekmovalci[indeks][4], tocke[indeks][0], uvrstitev[indeks], tocke[rezultati[0]][0] - tocke[indeks][0]);
        }
        izhod.close();
    }

    // končne rezultate tekme zapiše v podano datoteko (za vsakega tekmovalca obe daljavi in točke za seriji in skupaj)
    private static void shraniRezultateTekme(int[] rezultati, int[] uvrstitev, String dat) throws FileNotFoundException {
        PrintWriter izhod = new PrintWriter(dat);
        izhod.println("RANK;BIB;NAME;NSA;DIST-1;DIST-2;POINTS-1;POINTS-2;TOTAL");
        for (int i = 0; i < tekmovalci.length; i++) {
            int indeks = rezultati[i];
            izhod.printf("%d;%s;%s;%s;", uvrstitev[indeks], tekmovalci[indeks][0], tekmovalci[indeks][1], tekmovalci[indeks][4]);
            if (daljave[indeks][0] > 0)
                izhod.printf("%.1f;", daljave[indeks][0]);
            else
                izhod.printf("%s;", (daljave[indeks][0] < 0) ? "DSQ" : "-");
            if (daljave[indeks][1] > 0)
                izhod.printf("%.1f;", daljave[indeks][1]);
            else
                izhod.printf("%s;", (daljave[indeks][1] < 0 && daljave[indeks][0] > 0) ? "DSQ" : "-");
            if (tocke[indeks][0] > 0)
                izhod.printf("%.1f;", tocke[indeks][0]);
            else
                izhod.printf("-;");
            if (tocke[indeks][1] > 0)
                izhod.printf("%.1f;", tocke[indeks][1]);
            else
                izhod.printf("-;");
            izhod.printf("%.1f%n", tocke[indeks][2]);
        }
        izhod.close();
    }

    /* Metoda main - izvajanje programa po navodilih glede na podan ukaz */

    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        if (args.length < 2) {
            System.out.println("Uporaba: java DN08 [ukaz] [vhodne datoteke] [izhodne datoteke]");
            System.exit(1);
        }
        preberiTekmovalce(args[1]);
        switch (args[0].charAt(0)) {
            case '1':
                izpisiTekmovalce();
                break;
            case '2':
                preberiRezultate(1, args[2]);
                izpisiRezultate(1);
                break;
            case '3':
                for (int i = 0; i < SERIJE; i++) {
                    preberiRezultate(i + 1, args[i + 2]);
                }
                izpisiRezultate(SERIJE);
                break;
            case '4':
                preberiRezultate(1, args[2]);
                preberiOcene(1, args[3]);
                izracunajTocke(1);
                izpisiTocke(1);
                break;
            case '5':
                for (int i = 0; i < SERIJE; i++) {
                    preberiRezultate(i + 1, args[2 * i + 2]);
                    preberiOcene(i + 1, args[2 * i + 3]);
                    izracunajTocke(i + 1);
                }
                izpisiTocke(SERIJE);
                break;
            case '6':
                for (int i = 0; i < SERIJE; i++) {
                    preberiRezultate(i + 1, args[2 * i + 2]);
                    preberiOcene(i + 1, args[2 * i + 3]);
                    izracunajTocke(i + 1);
                }
                int[] rez = urediRezultate(1);
                int[] uvrstitev = dolociUvrstitev(rez, 1);
                shraniStartnoListo(rez, uvrstitev, args[6]);
                rez = urediRezultate(SERIJE);
                uvrstitev = dolociUvrstitev(rez, SERIJE);
                shraniRezultateTekme(rez, uvrstitev, args[7]);
                break;
            case '7':
                for (int i = 0; i < SERIJE; i++) {
                    preberiRezultate(i + 1, args[i + 2]);
                }
                izpisiNajmlajsega();
                break;
            case '8':
                for (int i = 0; i < SERIJE; i++) {
                    preberiOcene(i + 1, args[i + 2]);
                }
                izpisiSodnike();
                break;
            default:
                System.out.println("Ukaz je lahko 1, 2, 3, 4, 5, 6, 7 ali 8.");
        }
    }
}
