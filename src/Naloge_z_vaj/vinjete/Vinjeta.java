package vinjete;

public class Vinjeta {
    private String registrska;   // registrska številka vozila
    private String razred;       // vinjetni razred 1, 2A, 2B
    private String zacetniDatum; // datum začetka veljavnosti vinjete (dd.mm.yyyy)
    private String vrsta;        // letna, polletna, mesečna, tedenska

    public Vinjeta(String reg, String r, String dat, String vrsta) {
        this.registrska = reg;
        this.razred = r;
        this.zacetniDatum = dat;
        this.vrsta = vrsta;
    }

    public String getRegistrska() {
        return this.registrska;
    }

    public String getZacetniDatum() {
        return this.zacetniDatum;
    }

    public String getVrsta() {
        return this.vrsta;
    }

    public String getRazred() {
        return this.razred;
    }

    public String toString() {
        return String.format("%s [%s]: %s (%s)", this.registrska, this.razred, this.vrsta, this.zacetniDatum);
    }
}
