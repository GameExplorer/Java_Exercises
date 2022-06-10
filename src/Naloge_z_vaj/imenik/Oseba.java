package imenik;

public class Oseba {
    private String ime;
    private String priimek;
    private String kraj;
    private String telefon;
    private boolean mobilni; // true, če je telefon mobilna številka

    public Oseba(String ime, String priimek, String kraj, String telefon, boolean mobilni) {
        this.ime = ime;
        this.priimek = priimek;
        this.kraj = kraj;
        this.telefon = telefon;
        this.mobilni = mobilni;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public String getKraj() {
        return kraj;
    }

    public String getTelefon() {
        return telefon;
    }

    public boolean jeMobilni() {
        return mobilni;
    }

    public String toString() {
        return String.format("%s %s, %s: %s%s", ime, priimek, kraj, telefon, mobilni ? " (mobilni)" : "");
    }
}
