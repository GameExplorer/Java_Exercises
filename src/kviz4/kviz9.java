package kviz4;

public class kviz9 {
    public static void main(String[] args){
        histogram("src/kviz4/assets/ikona.p2b");
    }
    static void histogram(String imeDatoteke) {
        try {
            java.io.DataInputStream ds = new java.io.DataInputStream(new java.io.FileInputStream(new java.io.File(imeDatoteke)));
            if (imeDatoteke.substring(imeDatoteke.lastIndexOf(".")).equals(".p2b")) {
                if (ds.readByte() == 0x50 && ds.readByte() == 0x32 && ds.readByte() == 0x42) {
                    int sirina = ds.readInt();
                    int visina = ds.readInt();
                    java.util.TreeMap<String, Integer> barve = new java.util.TreeMap<>(
                            java.util.Comparator.comparingInt(o -> Integer.parseInt(o, 16))
                    );
                    for (int i = 0; i < sirina * visina; i++) {
                        byte r = ds.readByte();
                        byte g = ds.readByte();
                        byte b = ds.readByte();
                        String barva = Integer.toString(Integer.parseInt(String.format("%02x%02x%02x", r, g, b), 16), 16);
                        if (barve.containsKey(barva)) {
                            barve.put(barva, barve.get(barva) + 1);
                        } else {
                            barve.put(barva, 1);
                        }
                    }
                    for (java.util.Map.Entry<String, Integer> entry : barve.entrySet()) {
                        System.out.printf("%6s %d", entry.getKey(), entry.getValue());
                        System.out.println();
                    }
                } else {
                    System.out.println("Datoteka ni v formatu P2B: napaka pri podpisu slike.");
                }
            } else {
                System.out.println("Datoteka ni v formatu P2B: napaka v imenu datoteke.");
            }
            ds.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println(imeDatoteke + " (No such file or directory)");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Napi??i metodo

  void histogram(String imeDatoteke),

ki izra??una in izpi??e histogram slike, ki je v formatu p2b zapisana v datoteki imeDatoteke (format je podrobno opisan spodaj). Metoda histogram() naj preveri, ??e je podana datoteka v pravem formatu (kon??nica, podpis) - ??e ni, naj javi napako. ??e je format datoteke pravi, pa naj metoda prebere vsebino in izra??una histogram: za vsak piksel naj dolo??i njegovo barvo kot ??tiri bajtno celo ??tevilo (prvi bajt je enak ni??, sledijo pa si bajti R, G in B) in za vsako barvo izpi??e ??tevilo pikslov te barve v dani sliki. Izpisuje naj na standardni izhod, barve pa naj bodo urejene glede na ??tevila, s katerimi so predstavljene, v nara????ajo??em vrstnem redu. Na izhod v vsako vrstico izpi??ite barvo (v ??estnajsti??kem zapisu) in  ??tevilo pikslov te barve.



Primer: ob klicu histogram("ikona.p2b") naj metoda na standardni izhod izpi??e:



     0 9
 88008 9
 c0ca3 9
7f7f7f 16
ff0a0a 9
ff7f27 12
ffffff 3



Datoteka RGB.p2b torej vsebuje 4 barve: 19321 pikslov barv ff in ff00, 172352 pikslov barve cccccc in 19460 pikslov barve ff0000.

Pri testiranju se bodo uporabljale ??e naslednje datoteke: RGB.p2b, ikona1.p2b in ikona2.png.



Format p2b je binarna datoteka, v kateri so podatki zapisani po bajtih. Prvi trije bajti imajo ??estnajsti??ke vrednosti 50, 32 in 42 (ASCII podpis P2B). Sledi velikost slike, in sicer naslednji ??tirje bajti vsebujejo podatek o ??irini slike, naslednji ??tirje pa ??e o vi??ini slike. Nato sledi zaporedje bajtov, ki dolo??ajo piksle slike. Po trije bajti dolo??ajo en piksel (njegove r, g in b komponente).
 */