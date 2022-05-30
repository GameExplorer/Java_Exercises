package kviz4;

public class kviz1 {
    public static void main(String[] args) {

    }
    static void dvojnaNagrada(String igralkeFilename, String igralciFilename) {
        try{
            java.util.ArrayList<String[]> igralke = new java.util.ArrayList<>();
            java.util.ArrayList<String[]> igralci = new java.util.ArrayList<>();

            java.util.Scanner sc = new java.util.Scanner(new java.io.File(igralkeFilename));
            while (sc.hasNextLine()){
                String[] vrstica = sc.nextLine().split(",");
                for (int i = 0; i < vrstica.length; i++) {
                    vrstica[i] = vrstica[i].trim();
                }
                igralke.add(vrstica);
            }

            sc = new java.util.Scanner(new java.io.File(igralciFilename));
            while (sc.hasNextLine()){
                String[] vrstica = sc.nextLine().split(",");
                for (int i = 0; i < vrstica.length; i++) {
                    vrstica[i] = vrstica[i].trim();
                }
                igralci.add(vrstica);
            }
            sc.close();

            java.util.ArrayList<String> asd = new java.util.ArrayList<>();

            for (String[] igralka : igralke) {
                for (String[] igralec : igralci){
                    if (igralka[4].equals(igralec[4]) && igralec[1].equals(igralka[1])){
                        asd.add(String.format("Film: %s, Leto: %s, Igralka: %s, Igralec: %s", igralka[4], igralka[1], igralka[3], igralec[3]));
                    }
                }
            }

            java.util.Collections.sort(asd);
            for (String nagrada:
                    asd) {
                System.out.println(nagrada);
            }
        }
        catch (java.io.FileNotFoundException fne){
            System.out.println(fne);
        }

    }
}

/*
V datotekah imamo zapisane podatke o dobitnicah oziroma dobitnikih nagrad Oscar za najboljšo žensko oziroma moško vlogo.  Datoteke so ločene po spolih (v eni datoteki so samo dobitnice, v drugi samo dobitniki).  Vrstica v datoteki s podatki ima obliko:



Indeks, Leto, Starost, Ime in priimek, Naslov filma



(primer: 72, 1999, 26, "Gwyneth Paltrow", "Shakespeare in Love")



Podatki v datotekah niso nujno popolni (morda podatek za kakšno leto manjka).

Napiši metodo

  void dvojnaNagrade(String igralkeFilename, String igralciFilename),

ki kot parametra prejme imeni dveh datotek - ime datoteke z dobitnicami in ime datoteke z dobitniki nagrade Oscar, ter izpiše vse tiste filme, pri katerih sta dobila nagrado tako glavna igralka kot tudi glavni igralec. Filmi naj bodo pri izpisu urejeni po naslovu filma.



Primer: ob klicu metode



dvojnaNagrade("igralke.csv", "igralci.csv");



naj bo izhoda tak:



Film: "As Good as It Gets", Leto: 1998, Igralka: "Helen Hunt", Igralec: "Jack Nicholson"
Film: "Coming Home", Leto: 1979, Igralka: "Jane Fonda", Igralec: "Jon Voight"
 */