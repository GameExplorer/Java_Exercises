package Domace_Naloge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DN11 {
    public static void main(String[] args) throws FileNotFoundException{
        Locale.setDefault(Locale.US);

        CestnoOmrezje omrezje = CestnoOmrezje.izDatoteke(args[1]);
        if (args[0].equals("ceste")){
            System.out.println("Omrezje vsebuje naslednje ceste:");
            for(Cesta c:omrezje.getCeste()) {
                System.out.println(c);
            }
        } else if (args[0].equals("dolzinaPoti")) {
            int[] vozlisca = new int[args.length - 2];
            for(int i=0; i < vozlisca.length; i++){
                vozlisca[i] = Integer.parseInt(args[i + 2]);
            }
            omrezje.dolzinaPoti(vozlisca);
        } else if (args[0].equals("crpalkeObPoti")) {
            int[] vozlisca = new int[args.length - 2];
            for(int i=0; i < vozlisca.length; i++){
                vozlisca[i] = Integer.parseInt(args[i + 2]);
            }
            omrezje.crpalkeObPoti(vozlisca);
        } else if (args[0].equals("obremenjeneCeste")) {
            omrezje.obremenjeneCeste(args[2]);
        } else if (args[0].equals("izrisi")) {
            omrezje.izrisiOmrezje();
        } else if (args[0].equals("najkrajsaPot")) {
            omrezje.najboljsaPot(Integer.parseInt(args[2]), Integer.parseInt(args[3]), false);
        } else if (args[0].equals("najhitrejsaPot")) {
            omrezje.najboljsaPot(Integer.parseInt(args[2]), Integer.parseInt(args[3]), true);
        }
    }
}

class CestnoOmrezje{
    static final int IZRIS_SIRINA=1280;
    static final int IZRIS_VISINA=720;

    Vozlisce[] vozlisca;
    Cesta[] ceste;

    public CestnoOmrezje(Vozlisce[] vozlisca, Cesta[] ceste){
        this.vozlisca = vozlisca;
        this.ceste = ceste;
    }

    /**
     * Prebere cestno omrezje iz datoteke.
     * @param imeDatoteke Pot do datoteke z omrezjem.
     * @return Objekt tipa CestnoOmrezje, ki vsebuje vsa vozlisca in ceste.
     * @throws FileNotFoundException
     */
    public static CestnoOmrezje izDatoteke(String imeDatoteke) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(imeDatoteke));
        String[] line1 = sc.nextLine().split(" ");
        int nVozlisc = Integer.parseInt(line1[0]);
        int nCest = Integer.parseInt(line1[1]);

        // Vozlisca
        Vozlisce[] vozlisca = new Vozlisce[nVozlisc];
        for(int i=0; i<nVozlisc; i++){
            String[] line = sc.nextLine().split(" ");
            double x = Double.parseDouble(line[1]);
            double y = Double.parseDouble(line[2]);
            if(line[0].equals("vozlisce")){
                vozlisca[i] = new Vozlisce(i, x, y);
            } else if (line[0].equals("crpalka")){
                vozlisca[i] = new Crpalka(i, x, y, Double.parseDouble(line[3]), Double.parseDouble(line[4]));
            } else if (line[0].equals("kraj")){
                String[] besede = Arrays.copyOfRange(line, 3, line.length);
                String imeKraja = String.join(" ", besede);
                vozlisca[i] = new Kraj(i, x, y, imeKraja);
            }
        }

        // Ceste
        Cesta[] ceste = new Cesta[nCest];
        for(int i=0; i<nCest; i++){
            String[] line = sc.nextLine().split(" ");
            int i1 = Integer.parseInt(line[0]);
            int i2 = Integer.parseInt(line[1]);
            double omejitev = Double.parseDouble(line[2]);

            ceste[i] = new Cesta(i, vozlisca[i1], vozlisca[i2], omejitev);
            vozlisca[i1].dodajCesto(ceste[i]);
            vozlisca[i2].dodajCesto(ceste[i]);
        }

        sc.close();
        return new CestnoOmrezje(vozlisca, ceste);
    }

    /**
     * Izracuna dolzino in trajanje poti.
     * @param pot Pot podana kot tabela indeksov vozlisc.
     */
    public void dolzinaPoti(int[] pot){
        double skupnaDolzina = 0.0; // v km
        double skupenCas = 0.0; // v h

        for (int i=0; i<pot.length-1; i++) {
            // Pristej dolzino in cas
            Cesta c = getCesta(pot[i], pot[i+1]);
            skupnaDolzina += c.getDolzina();
            skupenCas += c.getDolzina() / c.getOmejitevHitrosti();
        }

        // Pretvori v ure in minute
        int ure = (int)skupenCas;
        int minute = (int)Math.round((skupenCas - ure) * 60);

        System.out.printf("Pot: %d", pot[0]);
        for(int i=1; i<pot.length; i++){
            System.out.printf(" - %d", pot[i]);
        }
        System.out.println();
        System.out.printf("Skupna dolzina: %.2f km\n", skupnaDolzina);
        System.out.printf("Predviden cas voznje: %dh %dmin\n", ure, minute);
    }

    /**
     * Izpise crpalke na ali v blizini poti.
     * @param pot Pot podana kot tabela indeksov vozlisc.
     */
    public void crpalkeObPoti(int[] pot){
        // slovar Crpalka -> razdalja do crpalke
        Map<Crpalka, Double> crpalke = new HashMap<>();

        for (int i=0; i<pot.length; i++) {
            Vozlisce v = this.vozlisca[pot[i]];
            if (v instanceof Crpalka){
                // Crpalke direktno na poti
                crpalke.put((Crpalka) v, 0.0);
            }
            for(Cesta c:v.getCeste()){
                // Crpalke v sosednjih vozliscih
                Vozlisce v2 = c.drugoVozlisce(v);
                double razdalja = c.getDolzina();
                if(v2 instanceof Crpalka){
                    Crpalka p = (Crpalka) v2;
                    if(crpalke.containsKey(p)){
                        crpalke.put(p, Math.min(razdalja, crpalke.get(p)));
                    } else {
                        crpalke.put(p, razdalja);
                    }
                }
            }
        }

        // Uredi crpalke po indeksu vozlisca
        ArrayList<Crpalka> crpalkeList = new ArrayList<>(crpalke.keySet());
        crpalkeList.sort(new Comparator<Crpalka>() {
            @Override
            public int compare(Crpalka o1, Crpalka o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        // Izpisi crpalke
        for(Crpalka p:crpalkeList) {
            double razdalja = crpalke.get(p);

            if(razdalja > 0) {
                System.out.printf("%s: %.2f km s poti\n", p, razdalja);
            } else {
                System.out.printf("%s: na poti\n", p);
            }
        }
    }

    /**
     * Izracuna obremenjenost cest glede na podatke o prometu.
     * @param datotekaPromet Datoteka z vsemi zabelezenimi potmi.
     * @throws FileNotFoundException
     */
    public void obremenjeneCeste(String datotekaPromet) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(datotekaPromet));
        int nPoti = Integer.parseInt(sc.nextLine());

        // Stevilo poti prek posamezne ceste
        int[] obremenjenostCest = new int[ceste.length];

        // Poti
        for(int i=0; i<nPoti; i++){
            String[] line = sc.nextLine().split(" ");
            // Pristej obremenjenost vsaki cesti na poti
            for(int j=0; j<line.length-1; j++){
                int i1 = Integer.parseInt(line[j]);
                int i2 = Integer.parseInt(line[j+1]);
                Cesta c = getCesta(i1, i2);
                obremenjenostCest[c.getId()] += 1;
            }
        }

        sc.close();

        // Izpis
        for(int i=0; i<obremenjenostCest.length; i++){
            Cesta c = ceste[i];
            System.out.printf("Cesta(%d,%d): %d poti (%.1f%%)\n", c.getV1().getId(), c.getV2().getId(), obremenjenostCest[i], (double)obremenjenostCest[i] / nPoti * 100);
        }
    }

    /**
     * Izrise omrezje s StdDraw.
     */
    public void izrisiOmrezje(){
        StdDraw.setCanvasSize(IZRIS_SIRINA, IZRIS_VISINA);

        // Poisci min in maks koordinate vozlisc (obmocje risanja).
        double xMin = vozlisca[0].getLon(), xMax = vozlisca[0].getLon();
        double yMin = vozlisca[0].getLat(), yMax = vozlisca[0].getLat();
        for(Vozlisce v:vozlisca){
            if(v.getLon() < xMin){
                xMin = v.getLon();
            } else if(v.getLon() > xMax){
                xMax = v.getLon();
            }
            if(v.getLat() < yMin){
                yMin = v.getLat();
            } else if(v.getLat() > yMax){
                yMax = v.getLat();
            }
        }

        // Dodaj se obrobo 10 % praznega prostora na vse strani
        double xPad = (xMax - xMin) * 0.1;
        double yPad = (yMax - yMin) * 0.1;
        xMin = xMin - xPad;
        xMax = xMax + xPad;
        yMin = yMin - yPad;
        yMax = yMax + yPad;

        // Sirina obmocja po x in po y
        double xRange = xMax - xMin;
        double yRange = yMax - yMin;

        // Risemo v koordinatah pikslov.
        StdDraw.setXscale(0,IZRIS_SIRINA);
        StdDraw.setYscale(0,IZRIS_VISINA);

        // Narisi ceste
        for(Cesta c:ceste){
            if (c.getOmejitevHitrosti() > 110) {
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.setPenRadius(0.002 * 8);
            } else if (c.getOmejitevHitrosti() > 90){
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenRadius(0.002 * 6);
            } else if (c.getOmejitevHitrosti() > 50) {
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.setPenRadius(0.002 * 4);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.setPenRadius(0.002 * 2);
            }

            // Pretvorimo koordinate v pixel prostor (enako pri vozliscih)
            StdDraw.line((c.getV1().getLon() - xMin) / xRange * IZRIS_SIRINA, (c.getV1().getLat() - yMin) / yRange * IZRIS_VISINA, (c.getV2().getLon() - xMin) / xRange * IZRIS_SIRINA, (c.getV2().getLat() - yMin) / yRange * IZRIS_VISINA);
        }

        // Narisi vozlisca
        for(Vozlisce v:vozlisca){

            if(v instanceof Crpalka){
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledSquare((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA, 10);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA, 5);
            } else if (v instanceof Kraj){
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.filledCircle((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA, 6);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA + 20, ((Kraj) v).getIme());
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA, 3);
            }

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text((v.getLon() - xMin) / xRange * IZRIS_SIRINA, (v.getLat() - yMin) / yRange * IZRIS_VISINA - 20, v.getId() + "");
        }
    }

    /**
     * Poisce najkrajso (cas=false) oz. najhitrejso (cas=true) pot med vozliscema i1 in i2.
     * @param i1 Indeks zacetnega vozlisca.
     * @param i2 Indeks koncnega vozlisca.
     * @param cas Ali iscemo najhitrejso pot?
     */
    public void najboljsaPot(int i1, int i2, boolean cas){
        Vozlisce v1 = vozlisca[i1];
        Vozlisce v2 = vozlisca[i2];

        // Najcenejsa (najkrajsa/najhitrejsa) pot od v1 do ostalih vozlisc
        double[] cene = new double[vozlisca.length];
        // Ali je vozlisce ze preiskano?
        boolean[] preiskano = new boolean[vozlisca.length];
        // Katero vozlisce je prejsnje?
        int[] prejsnji = new int[vozlisca.length];

        // Nastavi cene na naskoncno
        for(int i=0; i<cene.length; i++){
            cene[i] = Double.POSITIVE_INFINITY;
            preiskano[i] = false;
        }

        cene[i1] = 0.0; // Cena od v1 do v1 je 0
        for(int it=0; it<vozlisca.length-1; it++){
            // Poisci nepreiskano vozlisce z najmanjso vmesno ceno
            int iMin=-1;
            double minCena = Double.POSITIVE_INFINITY;
            for(int i=0; i<vozlisca.length; i++){
                if(!preiskano[i] && cene[i] < minCena){
                    minCena = cene[i];
                    iMin = i;
                }
            }

            // Ko pridemo do koncnega vozlisca (i2) lahko zakljucimo iskanje
            if(iMin == i2){
                break;
            }

            // Nastavi izbrano vozlisce kot zakljuceno
            preiskano[iMin] = true;
            Vozlisce vMin = vozlisca[iMin];

            // Preisci ceste, ki vodijo iz vMin
            for(Cesta c:vMin.getCeste()){
                Vozlisce vOut = c.drugoVozlisce(vMin);

                double cena;
                if (cas){
                    // cena = cas potovanja
                    cena = c.getDolzina() / c.getOmejitevHitrosti();
                } else {
                    // cena = dolzina poti
                    cena = c.getDolzina();
                }


                // Ce je cena do vMin + cena do soseda manjsa od trenutne cene do soseda, smo nasli boljso pot
                if (!preiskano[vOut.getId()] && (cene[iMin] + cena) < cene[vOut.getId()]){
                    cene[vOut.getId()] = cene[iMin] + cena;
                    prejsnji[vOut.getId()] = iMin;
                }
            }
        }

        // Rekonstruiraj pot
        ArrayList<Integer> potList = new ArrayList<>();
        int iCur = i2;
        potList.add(iCur);
        while(iCur != i1){
            iCur = prejsnji[iCur];
            potList.add(iCur);
        }
        Collections.reverse(potList);

        // Shrani v tabelo
        int[] pot = new int[potList.size()];
        for(int i=0; i<potList.size(); i++){
            pot[i] = potList.get(i);
        }

        // Izpisi podatke o poti
        dolzinaPoti(pot);
    }

    /**
     * Poisce cesto med vozliscema i1 in i2.
     * @param i1 Indeks vozlisca 1.
     * @param i2 Indeks vozlisca 2.
     * @return Cesta med vozliscema i1 in i2, ali null, ce ne obstaja.
     */
    public Cesta getCesta(int i1, int i2){
        Vozlisce v1 = vozlisca[i1];
        Vozlisce v2 = vozlisca[i2];
        for(Cesta c:ceste){
            if((c.getV1() == v1 && c.getV2() == v2) || (c.getV2() == v1 && c.getV1() == v2)){
                return c;
            }
        }
        return null;
    }

    public Cesta[] getCeste() {
        return ceste;
    }
}

class Vozlisce {
    private int id; // indeks vozlisca
    private double lat, lon;
    private List<Cesta> ceste;

    public Vozlisce(int id, double lat, double lon){
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        ceste = new ArrayList<>();
    }

    public void dodajCesto(Cesta cesta){
        ceste.add(cesta);
    }

    public int getId(){
        return id;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public List<Cesta> getCeste() {
        return ceste;
    }
}

class Kraj extends Vozlisce {
    private String ime;

    public Kraj(int id, double x, double y, String ime){
        super(id,x,y);
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }
}

class Crpalka extends Vozlisce {
    private double cena95;
    private double cenaDizel;

    public Crpalka(int id, double x, double y, double cena95, double cenaDizel){
        super(id,x,y);
        this.cena95 = cena95;
        this.cenaDizel = cenaDizel;
    }

    public double getCena95() {
        return cena95;
    }

    public double getCenaDizel() {
        return cenaDizel;
    }

    @Override
    public String toString() {
        return String.format("Crpalka(%d) [95: %.3f EUR, dizel: %.3f EUR]", getId(), cena95, cenaDizel);
    }
}

class Cesta {
    private int id;
    private Vozlisce v1, v2;
    private double omejitevHitrosti;

    public Cesta(int id, Vozlisce v1, Vozlisce v2, double omejitevHitrosti){
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.omejitevHitrosti = omejitevHitrosti;
    }

    public int getId(){
        return id;
    }

    public Vozlisce getV1() {
        return v1;
    }

    public Vozlisce getV2() {
        return v2;
    }

    public double getOmejitevHitrosti() {
        return omejitevHitrosti;
    }

    /**
     * Izracuna dolzino ceste glede na koordinate vozlisc.
     * @return Dolzina v km.
     */
    public double getDolzina(){
        double razdaljaLat = (v1.getLat()-v2.getLat()) * 111.12;
        double razdaljaLon = (v1.getLon()-v2.getLon()) * 77.4;
        return Math.sqrt(Math.pow(razdaljaLat,2) + Math.pow(razdaljaLon,2));
    }

    /**
     * Vrne nasprotno vozlisce v cesti od `v`.
     * @param v Eno izmed vozlisc ceste.
     * @return Drugo vozlisce.
     */
    public Vozlisce drugoVozlisce(Vozlisce v){
        if(v == this.v1){
            return v2;
        }else if(v == this.v2){
            return v1;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Cesta(%d,%d): dolzina=%.2f km, omejitev=%d km/h", v1.getId(), v2.getId(), getDolzina(), Math.round(omejitevHitrosti));
    }
}

