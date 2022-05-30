package kviz4;

public class kviz5 {
    public static void main(String[] args) {
        izpisi("assets/strito.dat");
    }
    static void izpisi(String imeDatoteke) {
        System.out.println("V datoteki " + imeDatoteke + " so naslednje številke:");
        try {
            java.io.FileInputStream fs = new java.io.FileInputStream(new java.io.File(imeDatoteke));
            int i = 1;
            StringBuilder trenutnaStevilka = new StringBuilder();
            while (fs.available() > 0) {
                int znak = fs.read();
                trenutnaStevilka.append(String.format("%8s", Integer.toBinaryString(znak)).replace(" ", "0"));
                if (i % 3 == 0) {
                    String stevilka = String.valueOf(Integer.parseInt(trenutnaStevilka.toString(), 2));
                    System.out.printf("0%s / %s %s",
                            stevilka.charAt(0), stevilka.substring(1, 4), stevilka.substring(4, 7));
                    System.out.println();
                    trenutnaStevilka = new StringBuilder();
                }
                i++;
            }
            fs.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Zloglasni mafijec Joe Enigma, ki je v prostem času rad tudi programiral, se je domislil enostavnega načina, kako bi telefonske številke svojih poslovnih partnerjev skril pred radovednimi očmi svojih rivalov in policijskih preiskovalcev: številke je shranil kar v binarno datoteko. Vse številke so sedemmestne: najprej je zapisana področna koda (1 do 9), tej pa sledi še šest števk (npr. 1123456 ali 9654321). Številke so zapisane v binarni datoteki kot 24-bitna števila (vsaka številka zasede po tri zaporedne bajte).

Napiši metodi

   void izpisi(String imeDatoteke)

in

  void preveri(String stevilka, String imeDatoteke).

Prva izpiše vse številke, ki so zapisane v datoteki, druga pa preveri in izpiše "Številka .... je v datoteki", če se telefonska številka nahaja v datoteki in "Številke .... ni  v datoteki", če se ne.



Primer: ob klicu preveri("03 / 973 081", "skrito.dat") metoda izpiše "Številka 03 / 973 081 je v datoteki", saj se število 3973081 nahaja v datoteki skrito.dat (zapisano je v prvih treh bajtih).



Pri preverjanju se bo uporabila datoteka strito.dat.
 */