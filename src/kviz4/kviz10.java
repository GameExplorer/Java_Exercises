package kviz4;

public class kviz10 {
    public static void main(String[] args) {

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
Napišite metodo

  void izpisi(int znak[]),

ki prejme tabelo 8-bitnih števil in izpiše znak, ki ga ta tabela predstavlja. Pri tem i-ti element tabele predstavlja i-to vrstico znaka po bitih: če je j-ti bit i-tega števila prižgan, je v i-ti vrstici na j-tem mestu izpisana zvezdica, sicer presledek.



Primer: ob klicu izpisi(new int[] {129, 129, 129, 255, 129, 129, 129, 129}) naj metoda izpiše črko H takole:



*      *

*      *

*      *

********

*      *

*      *

*      *

*      *
 */