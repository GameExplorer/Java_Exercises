package Izpiti.Poletni2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Naloga13 {
    private static ArrayList<Datoteka> datoteke = new ArrayList<>();

    public static void zberiVelikeDatoteke(File dat, int velikost) {
        if (dat.isDirectory()) {
            for (File d : dat.listFiles()) {
                zberiVelikeDatoteke(d, velikost);
            }
        } else if (dat.isFile()) {
            long velDat = dat.length(); // velikost datoteke v bajtih
            if (velDat >= velikost * 1024 * 1024) {
                datoteke.add(new Datoteka(dat.getName(), dat.getPath(), velDat));
            }
        }
    }

    public static void main(String[] args) {
        zberiVelikeDatoteke(new File(args[0]), Integer.parseInt(args[1]));
        Collections.sort(datoteke);
        for (Datoteka datoteka : datoteke) {
            System.out.println(datoteka);
        }
    }

}

class Datoteka implements Comparable<Datoteka> {
    private String ime;    // ime datoteke, brez poti
    private String pot;    // ime datoteke, vključno s potjo
    private long velikost; // velikost datoteke v bajtih

    public Datoteka(String ime, String pot, long vel) {
        this.ime = ime;
        this.pot = pot;
        this.velikost = vel;
    }

    public String toString() {
        return String.format("%s (%.1f MB)", this.pot, this.velikost / 1024.0 / 1024.0);
    }


    public int compareTo(Datoteka d) {
        // preimerjaj po velikosti
        int primerjava = Long.compare(this.velikost, d.velikost);
        if (primerjava == 0) {
            // če velikosti enaki, primerjaj imeni po abecedi
            int primerjavaImen = this.ime.compareTo(d.ime);
            if (primerjavaImen == 0) {
                // če tudi imeni enaki, primerjaj celo pot po abecedi
                return this.pot.compareTo(d.pot);
            }
            return primerjavaImen;
        }
        return -1 * primerjava;
    }
}
/*
Napiši program, ki v podanem direktoriju in vseh njegovih poddirektorijih poišče vse datoteke, ki so večje od podane velikosti.
Začetni direktorij in velikost (v MB, celo število) sta po vrsti podana kot argumenta programa.
Program naj izpiše vse najdene datoteke, urejene padajoče po velikosti (velikost zapiši v MB na eno
decimalko natančno). Če ima več datotek enako velikost, naj jih uredi po abecedi po imenu (brez poti),
če pa imajo tudi imena enaka, jih uredi po abecedi po celem imenu skupaj s potjo.  Primer: klic programa
java Naloga13 viri 5 poišče vse datoteke, večje od 5 MB, ki se nahajajo v direktoriju viri ali njegovih poddirektorijih.
Izpiše ustrezno urejen seznam vseh najdenih datotek, npr.:
 */