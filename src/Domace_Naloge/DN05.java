package Domace_Naloge;


/**
 * Program iz podanih argumentov sestavi niz ter prešteje, kolikokrat se
 * v tem nizu pojavi posamezna števka ('0', '1', ..., '9'). Ob koncu naj
 * program izpiše najbolj pogosto uporabljeno(e) števko(e) ter frekvenco
 * uporabe.
 *
 * Primer: ker se v nizu 'a8d 82 d1810x51' najpogosteje pojavita števki 1 in 8
 * (in to 3-krat), naj program ob klicu
 *
 *   java DN03 a8d 82 d1810x51
 *
 * naj program izpiše:
 *
 * 'a8d 82 d1810x51' -> 1 8 (3)
 *
 * Pri izpisu upoštevajte tudi primer, da v nizu ni nobene števke.
 *
 */
public class DN05 {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Uporaba: java DN05 <beseda>...");
            System.exit(0);
        }

        String niz = "";
        for (int i = 0; i < args.length; i++) {
            niz += args[i] + " ";
        }
        niz = niz.trim(); // "odrežem" presledek na koncu niza

        int steviloStevk = 0; // koliko stevk se je pojavilo v nizu

        // tabela stevke bo stela pojavitve posamezne števke; primer: stevke[0] steje
        // pojavitve števke '0', stevke[1] pojavitve števke '1', ...
        int[] stevke = new int[10];  // Ko naredim novo tabelo (z ukazom new), so v njej same ničle!

        // "sprehodim" se po nizu in zabeležim pojavitve števk v tabeli stevke
        for (int i = 0; i < niz.length(); i++) {
            if (niz.charAt(i) >= '0' && niz.charAt(i) <= '9') {
                steviloStevk++;
                stevke[niz.charAt(i) - '0']++;
            }
        }

        if (steviloStevk > 0) { // če se je pojavila vsaj ena števka

            int max = 0;
            // poiščem maksimalno število pojavitev katere od števk
            for (int i = 0; i < stevke.length; i++) {
                if (stevke[i] > max) {
                    max = stevke[i];
                }
            }

            // izpišem vse števke, ki se pojavijo max-krat
            System.out.printf("'%s' -> ", niz);
            for (int i = 0; i < stevke.length; i++) {
                if (stevke[i] == max) {
                    System.out.printf("%c ", (char)(i+'0'));
                }
            }
            System.out.printf("(%d)\n", max);
        } else { // če ni bilo nobene števke
            System.out.printf("V nizu '%s' ni stevk\n", niz);
        }
    }
}
