package Naloge_z_vaj.banka;

public class Banka {
    public static final int MAX_RACUNOV = 500; // omejitev števila računov za vse banke
    public Naloge_z_vaj.banka.Racun[] racuni = new Naloge_z_vaj.banka.Racun[MAX_RACUNOV]; // seznam vseh računov v banki
    public int steviloRacunov = 0; // število računov na banki

    // Poišče račun s podano številko in ga vrne; če takega računa ni, vrne null.
    public Naloge_z_vaj.banka.Racun vrniRacun(String stevilka) {
        for (int i = 0; i < steviloRacunov; i++) {
            if (racuni[i].getStevilka().equals(stevilka)) {
                return racuni[i];
            }
        }
        return null;
    }

    /**
     * Doda nov tekoči račun na seznam računov v banki.
     * Če račun s to številko že obstaja ali če je banka že dosegla svoje omejitve števila računov,
     * računa ne doda in vrne false.
     *
     * @param stevilka - številka novega računa
     * @param limit    - limit pri dvigu z računa
     */
    public void dodajTekociRacun(String stevilka, double limit) {
        if (vrniRacun(stevilka) == null && steviloRacunov < racuni.length) {
            banka.TekociRacun r = new banka.TekociRacun(stevilka, limit);
            racuni[steviloRacunov] = r;
            steviloRacunov++;
        }
    }

    /**
     * Doda nov varčevalni račun na seznam računov v banki.
     * Če račun s to številko že obstaja ali če je banka že dosegla svoje omejitve števila računov,
     * računa ne doda in vrne false.
     *
     * @param stevilka - številka novega računa
     * @param obresti  - obrestna mera pri novem računu
     */
    public void dodajVarcevalniRacun(String stevilka, double obresti) {
        if (vrniRacun(stevilka) == null && steviloRacunov < racuni.length) {
            racuni[steviloRacunov++] = new Racun(stevilka, obresti) {
                @Override
                protected String opisRacuna() {
                    return null;
                }
            };
        }
    }

    /**
     * Izpiše vse račune (tekoče in varčevalne) v banki in število vseh računov.
     */
    public void izpisiRacune() {
        System.out.println("Vsi računi (tekoči in varčevalni):");
        for (int i = 0; i < steviloRacunov; i++) {
            System.out.println(racuni[i]);
        }
        System.out.printf("Število vseh računov: %d%n", steviloRacunov);
    }

    /**
     * Izpiše vse račune določenega tipa: varčevalni (parameter je true) ali tekoči (parameter je false).
     *
     * @param varcevalni - tip računov, ki jih izpiše (true - varčevalni; false - tekoči)
     */
    public void izpisiRacune(boolean varcevalni) {
        int stevilo = 0;
        System.out.printf("%s računi:%n", varcevalni ? "Varčevalni" : "Tekoči");
        for (int i = 0; i < steviloRacunov; i++) {
            if (varcevalni && racuni[i] instanceof VarcevalniRacun) {
                System.out.println(racuni[i]);
                stevilo++;
            }
        }
        System.out.printf("Število vseh %s računov: %d%n", varcevalni ? "varčevalnih" : "tekočih", stevilo);
    }

    /**
     * S podanega računa dvigne podan znesek.
     *
     * @param stevilka - številka računa, s katerega dvigne znesek
     * @param znesek   - znesek, ki ga dvigne z računa
     * @return true, če je bil dvig uspešno izveden, sicer false
     */
    public boolean dvig(String stevilka, double znesek) {
        Naloge_z_vaj.banka.Racun r = vrniRacun(stevilka);
        if (r != null) {
            return r.dvig(znesek);
        }
        return false;
    }

    /**
     * Na podan račun položi podan znesek.
     *
     * @param stevilka - številka računa, na katerega položi znesek
     * @param znesek   - znesek, ki ga položi na račun
     * @return true, če je bil polog uspešno izveden, sicer false
     */
    public boolean polog(String stevilka, double znesek) {
        Naloge_z_vaj.banka.Racun r = vrniRacun(stevilka);
        if (r != null) {
            return r.polog(znesek);
        }
        return false;
    }

    /**
     * Vsem varčevalnim računom pripiše obresti.
     * S tem se spremenijo stanja na varčevalnih računih.
     */
    public void dodajObresti() {
        for (int i = 0; i < steviloRacunov; i++) {
            if (racuni[i] instanceof VarcevalniRacun) {
                ((VarcevalniRacun) racuni[i]).dodajObresti();
            }
        }
    }

    // Pomožna metoda za urejanje: primerja računa r1 in r2 po velikosti glede na polje.
    // Polje je "stevilka" ali "stanje".
    // Vrne true, če je r1 večje (padajoce = true) oz. manjše (padajoce = false) od r2.
    private boolean vecji(Naloge_z_vaj.banka.Racun r1, Naloge_z_vaj.banka.Racun r2, String polje, boolean padajoce) {
        if (polje.equals("stevilka")) {
            // primerjamo polje "stevilka"
            return (padajoce ? r1.getStevilka().compareTo(r2.getStevilka()) : r2.getStevilka().compareTo(r1.getStevilka())) > 0;
        }
        // primerjamo polje "stanje"
        return padajoce ? r1.getStanje() > r2.getStanje() : r1.getStanje() < r2.getStanje();
    }

    /**
     * Uredi račune v tabeli racuni glede na polje in podan vrstni red.
     * Na koncu je tabela racuni urejena.
     *
     * @param polje    - polje ("stevilka" ali "stanje"), po katerem uredi račune
     * @param padajoce - vrstni red urejanje računov (true za padajoče oz. false za naraščajoče)
     */
    public void sortirajRacune(String polje, boolean padajoce) {
        for (int i = 0; i < steviloRacunov - 1; i++) {
            for (int j = i + 1; j < steviloRacunov; j++) {
                if (vecji(racuni[j], racuni[i], polje, padajoce)) {
                    Naloge_z_vaj.banka.Racun tmp = racuni[i];
                    racuni[i] = racuni[j];
                    racuni[j] = tmp;
                }
            }
        }
    }
}
